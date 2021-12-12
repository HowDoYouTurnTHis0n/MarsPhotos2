package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private const val BASE_URL =
    "https://my-json-server.typicode.com/RepositorioOmega/DB/places/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("id")
    suspend fun getPhotos(): List<MarsPhoto>


    object MarsApi {
        val retrofitService : MarsApiService by lazy {
            retrofit.create(MarsApiService::class.java)
        }

    }
}

