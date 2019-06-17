package com.tapdevs.albums.injections.modules

import android.content.Context
import com.tapdevs.albums.ui.AlbumsActivity
import com.tapdevs.base.injection.qualifiers.ForActivity
import com.tapdevs.base.injection.scopes.PerActivity
import dagger.Module
import dagger.Provides

@Module(includes = [AlbumsModule.View::class])
class AlbumsModule {

    @Module
    class View {
        @Provides
        @PerActivity
        @ForActivity
        fun provideContext(activity: AlbumsActivity): Context = activity
    }
}