package com.example.vihaan.nativequestions

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
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

        questionWebView.loadData(getHtmlValue(question), "text/html", "UTF-8")
        option1WebView.loadData(getHtmlValue(options.get(0).value), "text/html", "UTF-8")
        option2WebView.loadData(getHtmlValue(options.get(1).value), "text/html", "UTF-8")
        option3WebView.loadData(getHtmlValue(options.get(2).value), "text/html", "UTF-8")
        option4WebView.loadData(getHtmlValue(options.get(3).value), "text/html", "UTF-8")
        solutionWebView.loadData(getHtmlValue(sol.value), "text/html", "UTF-8")
        }catch (e: Exception)
        {
            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
        }
    }

    @SuppressWarnings("deprecation")
    private fun getHtmlValue(value: String): String {
//        var htmlValue = "<html><body>"+value+"</body></html>"
//        var htmlValue = "<html><body>"+ Html.fromHtml(value)+"</body></html>"
//        var htmlValue = "<html><body>"+ Html.fromHtml(value,)+"</body></html>"
        var htmlValue:String
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            htmlValue = Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            htmlValue = Html.fromHtml(value).toString();
        }
        return htmlValue
    }
}