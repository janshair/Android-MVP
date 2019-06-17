package com.tapdevs.base.injection

import android.app.Application
import android.content.Context
import com.tapdevs.base.injection.qualifiers.ForApplication
import dagger.Module
import dagger.Provides
import com.tapdevs.base.injection.scopes.PerApplication
import timber.log.Timber

@Module
class BaseModule {

    @Provides
    @PerApplication
    @ForApplication
    fun provideContext(application: Application): Context = application

    @Provides
    @PerApplication
    fun provideLogger(): Timber.Tree = Timber.DebugTree()
}