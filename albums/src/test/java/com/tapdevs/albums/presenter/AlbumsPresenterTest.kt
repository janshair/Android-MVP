package com.tapdevs.albums.presenter

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.tapdevs.base.BasePresenterTest
import com.tapdevs.base.network.model.Album
import com.tapdevs.base.network.rest.RestClientAlbums
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AlbumsPresenterTest : BasePresenterTest<AlbumsPresenter, AlbumsPresenter.View>() {

    private val publishSubject: PublishSubject<Any> = PublishSubject.create<Any>()

    private val restClientAlbums: RestClientAlbums = mock()

    override fun createPresenter(): AlbumsPresenter = AlbumsPresenter(restClientAlbums, Schedulers.trampoline(), Schedulers.trampoline())

    override fun createView(): AlbumsPresenter.View {
        val view: AlbumsPresenter.View = mock()
        whenever(view.onRetryClick()).thenReturn(publishSubject)
        return view
    }

    @Test
    fun onRetryClick_OnSuccess_Verify() {
        presenterOnViewAttached()
        verify(presenter).fetchAlbums()
    }

    @Test
    fun onRetryClick_OnError_Verify() {
        val throwable: Throwable = mock()
        whenever(view.onRetryClick()).thenReturn(Observable.error(throwable))
        presenterOnViewAttached()
        verify(view).showOfflineLayout(true)
        verify(view).showErrorMessage()
    }

    @Test
    fun fetchAlbums_OnSuccess_Verify() {
        val albumList: List<Album> = mock()
        whenever(restClientAlbums.albumsList()).thenReturn(Single.just(albumList))
        presenterOnViewAttached()
        verify(view).showOfflineLayout(false)
        verify(view).updateList(albumList)
    }

    @Test
    fun fetchAlbums_OnError_Verify() {
        val throwable: Throwable = mock()
        whenever(restClientAlbums.albumsList()).thenReturn(Single.error(throwable))
        presenterOnViewAttached()
        verify(view).showOfflineLayout(true)
        verify(view).showErrorMessage()
    }
}