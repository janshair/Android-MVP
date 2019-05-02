package com.tapdevs.albums.viewmodel

import android.databinding.BaseObservable
import com.tapdevs.base.network.model.Album

class AlbumViewModel: BaseObservable() {

    fun getUserId(album: Album) : String = "User id : ${album.userId}"

    fun getId(album: Album) : String = "Id : ${album.id}"

    fun getTitle(album: Album) : String = "Title : ${album.title}"
}