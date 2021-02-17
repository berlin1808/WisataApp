package com.example.wisataapp.network

import com.example.wisataapp.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET as GET


interface WisataService {
    @GET("api?action=findAll")
    fun getDataWisata():Call<ResponseServer>
}