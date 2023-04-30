package com.photoworld.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitController {

    fun getClient(): ClientAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ClientAPI::class.java)
    }

    companion object {

        private const val BASE_URL = "http://212.109.195.151:9090/api/v1/"

    }

}