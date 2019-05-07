package com.tapdevs.albums.ui

import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import com.tapdevs.albums.R
import com.tapdevs.albums.presenter.AlbumsPresenter
import com.tapdevs.albums.ui.adapter.AlbumsAdapter
import com.tapdevs.base.network.model.Album
import com.tapdevs.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_albums.*
import kotlinx.android.synthetic.main.view_offline.*
import javax.inject.Inject

class AlbumsActivity : BaseActivity(), AlbumsPresenter.View {

    @Inject lateinit var albumsPresenter: AlbumsPresenter

    override val layoutResourceId: Int
        get() = R.layout.activity_albums

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        albumsPresenter.onViewAttached(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        albumsPresenter.onViewDetached()
    }

    override fun showErrorMessage() {
        offlineText.text = getString(R.string.error_message)
    }

    override fun updateList(albumsList: List<Album>) {
        rvAlbums.adapter = AlbumsAdapter().apply { setItems(albumsList) }
    }

    override fun onRetryClick() = RxView.clicks(offlineActionButton)

    override fun showOfflineLayout(show: Boolean) {
        if (show) {
            rvAlbums.visibility = View.GONE
            offlineLayout.visibility = View.VISIBLE
        } else {
            rvAlbums.visibility = View.VISIBLE
            offlineLayout.visibility = View.GONE
        }
    }
}