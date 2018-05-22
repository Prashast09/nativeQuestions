package com.example.vihaan.nativequestions

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.vihaan.nativequestions.models.Question
import com.testbook.tbapp.html.HtmlEscape
import kotlinx.android.synthetic.main.fragment_question.*
import java.io.File
import java.util.regex.Pattern

class QuestionFragment : Fragment() {


    private lateinit var question: Question

    companion object {
        fun newInstance(bundle: Bundle) = QuestionFragment().apply { arguments = bundle }
        val KEY_QUESTION = "question"
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
        if (containsKey != null) {
            question = arguments?.getParcelable(KEY_QUESTION)!!
            setQuestionView(question)
        }
    }


    private fun setQuestionView(question: Question) {
        try {

            val en = question.en
            val question = en.value
            val options = en.options
            val sol = en.sol.get(0)

            initWebViews()

            val htmlValue = getHtmlValue(question)
            val correctImagesSrc = correctImagesSrc(htmlValue)
//        questionWebView.loadData(getHtmlValue(correctImagesSrc(question)!!), "text/html", "UTF-8")
            questionWebView.loadData(correctImagesSrc, "text/html", "UTF-8")
            option1WebView.loadData(getHtmlValue(options.get(0).value), "text/html", "UTF-8")
            option2WebView.loadData(getHtmlValue(options.get(1).value), "text/html", "UTF-8")
            option3WebView.loadData(getHtmlValue(options.get(2).value), "text/html", "UTF-8")
            option4WebView.loadData(getHtmlValue(options.get(3).value), "text/html", "UTF-8")
            solutionWebView.loadData(getHtmlValue(sol.value), "text/html", "UTF-8")
        } catch (e: Exception) {
            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun initWebViews(){
        questionWebView.settings.javaScriptEnabled = true
        option1WebView.settings.javaScriptEnabled = true
        option2WebView.settings.javaScriptEnabled = true
        option3WebView.settings.javaScriptEnabled = true
        option4WebView.settings.javaScriptEnabled = true
        solutionWebView.settings.javaScriptEnabled = true
    }

    @SuppressWarnings("deprecation")
    private fun getHtmlValue(value: String): String {
//        var htmlValue = "<html><body>"+value+"</body></html>"
//        var htmlValue = "<html><body>"+ Html.fromHtml(value)+"</body></html>"
        var htmlValue = "<html><head>"+getMathJaxScript()+"</head><body>"+ HtmlEscape.unescapeHtml (value) +"</body></html>"
//        var htmlValue: String
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            htmlValue = Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY).toString();
//        } else {
//            htmlValue = Html.fromHtml(value).toString();
//        }
        return htmlValue
    }

    private fun getMathJaxScript(): String {
        return "<script type=\"text/x-mathjax-config\">MathJax.Hub.Config({messageStyle: 'none',tex2jax: {preview: 'none'}});\n</script>"+
                "<script src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.4/MathJax.js?config=TeX-MML-AM_CHTML' async></script>"
    }

    private fun getJaxScript(): String {
        return ("<script type='text/x-mathjax-config'>"
                + "MathJax.Hub.Config({ "
                + "showMathMenu:false, "
                + "jax:['input/TeX','output/SVG'], "
                + "extensions:['tex2jax.js'], "
                + "TeX:{ extensions:['AMSmath.js','AMSsymbols.js', 'noErrors.js','noUndefined.js'] }, "
                + "'HTML-CSS': { linebreaks: { automatic: true } },"
                + "SVG: { linebreaks: { automatic: true } }"
                + "}); </script>"
                + "<script type='text/javascript' "
                + "src='file:///android_asset/mathjax/MathJax.js'"
                + "></script>")
    }


    fun correctImagesSrc(input: String): String? {
        var input = input
        if (TextUtils.isEmpty(input))
            return input
        val pattern = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>")
        val matcher = pattern.matcher(input)
        while (matcher.find()) {
            val url = matcher.group(1)
            val file = File(getImgDir(), Integer.toString(url.hashCode()))
            if (file.exists())
                input = input.replace(url.toRegex(), Uri.fromFile(file).toString())
            else if (url.startsWith("//")) {
                input = input.replace(url.toRegex(), "http:$url")
            }
        }
        return input
    }

    val TESTBOOK_QUESTIONS_IMAGE_DIR = "Testbook/qs"

    fun getImgDir(): String {
        return (Environment.getExternalStorageDirectory().toString()
                + File.separator
                + TESTBOOK_QUESTIONS_IMAGE_DIR
                + File.separator)
    }

}