package com.example.vihaan.nativequestions

import com.example.vihaan.nativequestions.models.QuestionsResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface  QuestionService{

//        @GET("/practice/55a5784fa7b57b49a29e2125/55d040302a39656d0ed7201f/questions?limit=20&skip=0&")
        @GET("https://api.myjson.com/bins/zl62i")
        fun getQuestions(

        ): Single<QuestionsResponse>
}