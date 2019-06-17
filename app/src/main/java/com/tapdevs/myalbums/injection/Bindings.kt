package com.tapdevs.myalbums.injection

import com.tapdevs.albums.ui.AlbumsActivity
import com.tapdevs.albums.injections.modules.AlbumsModule
import com.tapdevs.base.injection.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Bindings {

    @PerActivity
    @ContributesAndroidInjector(modules = [AlbumsModule::class])
    abstract fun bindAlbumsActivity(): AlbumsActivity
}