package com.example.vihaan.nativequestions

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vihaan.nativequestions.models.Question

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

    }
}