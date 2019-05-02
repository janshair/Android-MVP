package com.tapdevs.albums.presenter

import com.tapdevs.base.BasePresenter
import com.tapdevs.base.injection.qualifiers.NamedScheduler
import com.tapdevs.base.network.model.Album
import com.tapdevs.base.network.rest.RestClientAlbums
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

class AlbumsPresenter @Inject constructor(
    private val restClientAlbums: RestClientAlbums,
    @NamedScheduler(NamedScheduler.SchedulerType.IO) private val backgroundScheduler: Scheduler,
    @NamedScheduler(NamedScheduler.SchedulerType.UI) private val uiScheduler: Scheduler
    ): BasePresenter<AlbumsPresenter.View>() {

    override fun onViewAttached(view: View) {
        super.onViewAttached(view)
        disposeOnViewDetach(view.onRetryClick().subscribe({fetchAlbums()}, {view.showOfflineLayout(true)
            view.showErrorMessage()}))
        fetchAlbums()
    }

    fun fetchAlbums() {
        disposeOnViewDetach(restClientAlbums.albumsList()
            .subscribeOn(backgroundScheduler)
            .observeOn(uiScheduler)
            .subscribe({
                view?.showOfflineLayout(false)
                view?.updateList(it)
            }, {
                view?.showOfflineLayout(true)
                view?.showErrorMessage()
            }))
    }

    interface View {
        fun showErrorMessage()
        fun updateList(albumsList: List<Album>)
        fun onRetryClick(): Observable<Any>
        fun showOfflineLayout(show: Boolean)
    }
}