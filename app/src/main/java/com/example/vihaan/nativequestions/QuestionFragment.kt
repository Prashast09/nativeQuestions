package com.example.vihaan.nativequestions

import android.os.Bundle
import android.support.v4.app.Fragment

class QuestionFragment : Fragment() {

    companion object {
        fun newInstance(bundle: Bundle) = QuestionFragment().apply { arguments = bundle }
        val KEY_QUESTION="question"
    }

}