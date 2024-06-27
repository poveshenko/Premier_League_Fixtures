package com.example.crimedigital.premierleaguefixtures.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.crimedigital.premierleaguefixtures.data.MatchDataSource
import com.example.crimedigital.premierleaguefixtures.data.repository.MatchRepository
import com.example.crimedigital.premierleaguefixtures.model.MatchModel
import kotlinx.coroutines.flow.Flow

class MatchViewModel(private val repository: MatchRepository) : ViewModel() {
    // Создает Flow постраничных данных матчей
    val matchFlow: Flow<PagingData<MatchModel>> = Pager(PagingConfig(pageSize = 10)) {
        MatchDataSource(repository)
    }.flow.cachedIn(viewModelScope)
}

//MatchViewModel управляет данными для пользовательского интерфейса.
//matchFlow используется для загрузки данных постранично.
//cachedIn сохраняет кэш данных в рамках жизненного цикла ViewModel.