package com.example.vihaan.nativequestions

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.vihaan.nativequestions.models.Question
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment() {



    private lateinit var question:Question

    companion object {
        fun newInstance(bundle: Bundle) = QuestionFragment().apply { arguments = bundle }
        val KEY_QUESTION="question"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val containsKey = arguments?.containsKey(KEY_QUESTION)
        if(containsKey!=null)
        {
            question = arguments?.getParcelable(KEY_QUESTION)!!
            setQuestionView(question)
        }
    }


    private fun setQuestionView(question: Question)
    {
        try {

        val en = question.en
        val question = en.value
        val options = en.options
        val sol = en.sol.get(0)

        questionWebView.loadData(question, "text/html", "UTF-8")
        option1WebView.loadData(options.get(0).value, "text/html", "UTF-8")
        option2WebView.loadData(options.get(1).value, "text/html", "UTF-8")
        option3WebView.loadData(options.get(2).value, "text/html", "UTF-8")
        option4WebView.loadData(options.get(3).value, "text/html", "UTF-8")
        solutionWebView.loadData(sol.value, "text/html", "UTF-8")
        }catch (e: Exception)
        {
            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
        }
    }
}