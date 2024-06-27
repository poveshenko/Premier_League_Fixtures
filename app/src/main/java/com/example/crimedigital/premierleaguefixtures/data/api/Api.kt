package com.example.crimedigital.premierleaguefixtures.data.api

import com.example.crimedigital.premierleaguefixtures.model.MatchModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MatchApiService {
    // Определяет HTTP запрос для получения списка матчей
    @GET("feed/json/epl-2023")
    suspend fun getMatches(): List<MatchModel>
}

object MatchApi {
    private const val BASE_URL = "https://fixturedownload.com/"

    // Создает и настраивает экземпляр Retrofit для работы с API
    val retrofitService: MatchApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MatchApiService::class.java)
    }
}


//Retrofit используется для создания HTTP-запросов.
//MatchApiService определяет HTTP-запросы к серверу.
//MatchApi создает и настраивает экземпляр Retrofit.