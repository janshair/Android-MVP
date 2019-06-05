package com.tapdevs.albums.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tapdevs.albums.R
import com.tapdevs.base.network.model.Album
import kotlinx.android.synthetic.main.row_album.view.*

class AlbumsAdapter : RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    var albums: List<Album> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsAdapter.AlbumViewHolder {
        return AlbumViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.row_album, parent, false))
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album: Album = albums[position]
        holder.albumID.text = album.id.toString()
        holder.userID.text = album.userId.toString()
        holder.title.text = album.title
    }

    fun setItems(albums: List<Album>) {
        this.albums = albums
        notifyDataSetChanged()
    }
    inner class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var albumID: TextView
        var userID: TextView
        var title: TextView
        init {
            albumID = view.albumID
            userID = view.albumID
            title = view.albumID
        }
    }
}