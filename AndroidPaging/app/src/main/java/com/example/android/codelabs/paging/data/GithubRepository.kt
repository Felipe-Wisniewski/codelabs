package com.example.android.codelabs.paging.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import com.example.android.codelabs.paging.api.GithubService
import com.example.android.codelabs.paging.api.searchRepos
import com.example.android.codelabs.paging.db.GithubLocalCache
import com.example.android.codelabs.paging.model.RepoSearchResult

/** Repository class that works with local and remote data sources. */
class GithubRepository(private val service: GithubService, private val cache: GithubLocalCache) {


    /** Search repositories whose names match the query. */
    fun search(query: String): RepoSearchResult {
        Log.d("GithubRepository", "New query: $query")

        val dataSourceFactory = cache.reposByName(query)

        val boundaryCallback = RepoBoundaryCallback(query, service, cache)
        val networkErrors = boundaryCallback.networkErrors

        val data = LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
                .setBoundaryCallback(boundaryCallback)
                .build()

        return RepoSearchResult(data, networkErrors)
    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }
}
