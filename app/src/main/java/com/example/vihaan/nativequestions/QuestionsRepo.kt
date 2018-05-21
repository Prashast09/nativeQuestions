package com.example.vihaan.nativequestions

import com.example.vihaan.nativequestions.models.Question
import com.example.vihaan.nativequestions.models.QuestionsResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class QuestionsRepo{

    private var questionService:QuestionService
    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.testbook.com/api/v2")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()

        questionService = retrofit.create(QuestionService::class.java)
    }

    fun getQuestions(): Single<MutableList<Question>?>? {
        return questionService.getQuestions()
                .map { response -> getArray(response)}
    }

    fun getArray(response: QuestionsResponse): MutableList<Question>? {
        return response.data.questions
    }

}