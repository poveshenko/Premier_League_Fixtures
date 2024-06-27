package com.example.crimedigital.premierleaguefixtures.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.crimedigital.premierleaguefixtures.data.repository.MatchRepository
import com.example.crimedigital.premierleaguefixtures.model.MatchModel
import kotlinx.coroutines.flow.first

class MatchDataSource(private val repository: MatchRepository) : PagingSource<Int, MatchModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MatchModel> {
        return try {
            val pageNumber = params.key ?: 0
            val matches = repository.getMatches().first()

            val fromIndex = pageNumber * params.loadSize
            val toIndex = (pageNumber + 1) * params.loadSize.coerceAtMost(matches.size)

            if (fromIndex >= matches.size) {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = if (pageNumber > 0) pageNumber - 1 else null,
                    nextKey = null
                )
            } else {
                val pagedMatches = matches.subList(fromIndex, toIndex)
                LoadResult.Page(
                    data = pagedMatches,
                    prevKey = if (pageNumber > 0) pageNumber - 1 else null,
                    nextKey = if (toIndex < matches.size) pageNumber + 1 else null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MatchModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

//MatchDataSource отвечает за загрузку данных для пагинации.
//load загружает данные и возвращает их постранично.
//getRefreshKey определяет ключ для обновления данных.