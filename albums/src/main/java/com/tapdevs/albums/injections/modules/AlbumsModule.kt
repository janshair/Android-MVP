package com.tapdevs.albums.injections.modules

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.tapdevs.albums.ui.AlbumsActivity
import com.tapdevs.base.injection.qualifiers.ForActivity
import com.tapdevs.base.injection.scopes.PerActivity
import dagger.Module
import dagger.Provides

@Module(includes = [AlbumsModule.View::class])
class AlbumsModule{

    @Module
    class View {
        @Provides
        @PerActivity
        @ForActivity
        fun provideContext(activity: AlbumsActivity): Context = activity

        @Provides
        @PerActivity
        fun provideLayoutManager(@ForActivity context: Context): LinearLayoutManager =
            LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
    }
}