package com.tapdevs.albums.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tapdevs.albums.R
import com.tapdevs.albums.databinding.RowAlbumBinding
import com.tapdevs.albums.viewmodel.AlbumViewModel
import com.tapdevs.base.network.model.Album

class AlbumsAdapter : RecyclerView.Adapter<AlbumsAdapter.BindingHolder>() {

    var albums: List<Album> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsAdapter.BindingHolder {
        val rowAlbumBinding: RowAlbumBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_album,
            parent,
            false
        )
        return BindingHolder(rowAlbumBinding)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val rowAlbumBinding: RowAlbumBinding = holder.binding
        rowAlbumBinding.viewModel = AlbumViewModel()
        rowAlbumBinding.album = albums[position]
        rowAlbumBinding.executePendingBindings()
    }

    fun setItems(albums: List<Album>) {
        this.albums = albums
        notifyDataSetChanged()
    }
    inner class BindingHolder(binding: RowAlbumBinding) : RecyclerView.ViewHolder(binding.containerItem) {
        val binding: RowAlbumBinding

        init {
            this.binding = binding
        }
    }
}