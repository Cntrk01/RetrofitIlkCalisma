package com.example.retrofitfreecalisma_1.service

import com.example.retrofitfreecalisma_1.model.DataClass
import io.reactivex.Single
import retrofit2.http.GET

interface VeriAPI {
        //https://jsonplaceholder.typicode.com/posts
       @GET("/posts")
       fun getApiData() : Single<List<DataClass>>
}