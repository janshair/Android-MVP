package com.tapdevs.myalbums

import android.app.Activity
import android.app.Application
import com.tapdevs.myalbums.injection.DaggerMyAlbumsAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

open class MyAlbumsApp : Application(), HasActivityInjector {

    @Inject
    lateinit var loggingTree: Timber.Tree
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerMyAlbumsAppComponent.builder().application(this).build().inject(this)
        setupDebugTools()
    }

    private fun setupDebugTools() {
        initTimber()
    }

    private fun initTimber() {
        Timber.plant(loggingTree)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}