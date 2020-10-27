package com.example.idolos

import com.example.idolos.repository.IdolosRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImplementation {
    val BASE_URL = "https://5f92f6cd8742070016da640b.mockapi.io/"

    fun criarRequisiçoes(): IdolosRepository {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(IdolosRepository::class.java)
    }

}