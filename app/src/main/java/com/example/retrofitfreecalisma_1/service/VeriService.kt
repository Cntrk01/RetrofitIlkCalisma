package com.example.retrofitfreecalisma_1.service

import com.example.retrofitfreecalisma_1.model.DataClass
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class VeriService {
    private val BASE_URL="https://jsonplaceholder.typicode.com"
    private val api=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(VeriAPI::class.java)

    fun getData():Single<List<DataClass>>{
        return api.getApiData()
    }
}