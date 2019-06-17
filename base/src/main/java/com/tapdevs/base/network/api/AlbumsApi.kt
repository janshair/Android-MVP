package com.tapdevs.base.network.api

import com.tapdevs.base.network.model.Album
import io.reactivex.Single
import retrofit2.http.GET

interface AlbumsApi {

    @get:GET("albums")
    val albums: Single<List<Album>>
}