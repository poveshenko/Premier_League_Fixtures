package com.example.crimedigital.premierleaguefixtures.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.crimedigital.premierleaguefixtures.model.MatchModel

class MatchDataSource(private val matchList: List<MatchModel>) : PagingSource<Int, MatchModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MatchModel> {
        return try {
            val pageNumber = params.key ?: 0
            val pageSize = params.loadSize

            val fromIndex = pageNumber * pageSize
            val toIndex = (pageNumber + 1) * pageSize.coerceAtMost(matchList.size)

            if (fromIndex >= matchList.size) {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = if (pageNumber > 0) pageNumber - 1 else null,
                    nextKey = null
                )
            } else {
                val matches = matchList.subList(fromIndex, toIndex)
                LoadResult.Page(
                    data = matches,
                    prevKey = if (pageNumber > 0) pageNumber - 1 else null,
                    nextKey = if (toIndex < matchList.size) pageNumber + 1 else null
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
