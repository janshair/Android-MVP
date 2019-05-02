package com.tapdevs.albums.viewmodel

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.tapdevs.base.network.model.Album
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AlbumViewModelTest() {

    val album: Album = mock()
    val albumViewModel: AlbumViewModel = AlbumViewModel()

    @Before
    fun setUp() {
        whenever(album.id).thenReturn(1)
        whenever(album.userId).thenReturn(1)
        whenever(album.title).thenReturn("test")
    }

    @Test
    fun setUserID_AssertEqualsTrue() {
        assertEquals("User id : 1", albumViewModel.getUserId(album))
    }

    @Test
    fun setId_AssertEqualsTrue() {
        assertEquals("Id : 1", albumViewModel.getId(album))
    }

    @Test
    fun setTitle_AssertEqualsTrue() {
        assertEquals("Title : test", albumViewModel.getTitle(album))
    }
}