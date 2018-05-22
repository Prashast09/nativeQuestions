package com.example.vihaan.nativequestions

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.vihaan.nativequestions.models.Question
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class QuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
        init()
    }

    private fun init() {
        getQuestions()
    }

    private fun getQuestions() {
        QuestionsRepo().getQuestions()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(
                        {
                            it?.let {
                                setQuestions(it)
                            }
                        }, {

                })
    }

    private fun setQuestions(it: MutableList<Question>) {
        initViewPager(it)
    }

    lateinit var adapter: PagerAdapter
    private fun initViewPager(it: MutableList<Question>) {
        adapter = PagerAdapter(supportFragmentManager, getFragments(it))
        viewPager.adapter = adapter
    }

    private fun getFragments(it: MutableList<Question>): ArrayList<Fragment> {
        val fragments = arrayListOf<Fragment>()

        for(question in it)
        {
            val bundle = Bundle()
            bundle.putParcelable(QuestionFragment.KEY_QUESTION, question)
            fragments.add(QuestionFragment.newInstance(bundle))
//            break
        }
        return fragments
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
