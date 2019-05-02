package com.tapdevs.base.network.rest

import com.tapdevs.base.network.api.AlbumsApi
import com.tapdevs.base.network.model.Album
import io.reactivex.Single
import retrofit2.Retrofit

class RestClientAlbums(retrofit: Retrofit, private val errorMapper: ErrorMapper) {

    private val albumsApi: AlbumsApi = retrofit.create(AlbumsApi::class.java)

    fun albumsList(): Single<List<Album>> {
        return albumsApi.albums
            .onErrorResumeNext { throwable ->
                Single.error(errorMapper.mapErrorToException(throwable))
            }

    }
}