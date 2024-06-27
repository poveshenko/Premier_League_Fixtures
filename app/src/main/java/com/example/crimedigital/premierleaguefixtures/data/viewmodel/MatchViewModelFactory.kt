package com.example.crimedigital.premierleaguefixtures.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.crimedigital.premierleaguefixtures.data.repository.MatchRepository

class MatchViewModelFactory(private val repository: MatchRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MatchViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

//MatchViewModelFactory создает экземпляры MatchViewModel.
//Используется для предоставления зависимостей в MatchViewModel.