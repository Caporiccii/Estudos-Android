package com.example.idolos.repository

import com.example.continuada2.model.Idolos
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface IdolosRepository {
    @GET("idolos")
    fun getIdolos():Call<List<Idolos>>

    @GET("idolos/{id}")
    fun getIdolosById():Call<Idolos>

    @POST("idolos")
    fun postIdolos(@Body idolos: Idolos):Call<Void>

    @DELETE("idolos/{id}")
    fun deleteIdolos():Call<Void>
}