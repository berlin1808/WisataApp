package com.example.wisataapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getRetrofit() : WisataService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://udacoding.com/  ")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(WisataService::class.java)
            return service
        }
    }
}