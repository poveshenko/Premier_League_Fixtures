package com.example.crimedigital.premierleaguefixtures.data.repository

import com.example.crimedigital.premierleaguefixtures.data.api.MatchApiService
import com.example.crimedigital.premierleaguefixtures.model.MatchModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MatchRepository(private val apiService: MatchApiService) {
    // Возвращает Flow списка матчей, загруженных из API
    fun getMatches(): Flow<List<MatchModel>> = flow {
        emit(apiService.getMatches())
    }
}

//MatchRepository управляет данными и взаимодействует с MatchApiService для получения данных из API.
//getMatches возвращает данные в виде Flow, что позволяет асинхронно обрабатывать данные.