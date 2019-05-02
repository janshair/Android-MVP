package com.tapdevs.base

import android.support.annotation.CallSuper
import org.junit.Before
import org.mockito.MockitoAnnotations

public abstract class BasePresenterTest<P : BasePresenter<V>, V : Any> {
    protected lateinit var presenter: P
    protected lateinit var view: V

    @CallSuper
    @Before
    open fun before() {
        MockitoAnnotations.initMocks(this)

        presenter = createPresenter()
        view = createView()
    }

    protected abstract fun createPresenter(): P

    protected abstract fun createView(): V

    protected open fun presenterOnViewAttached() {
        presenter.onViewAttached(view)
    }

    protected fun presenterOnViewDetached() {
        presenter.onViewDetached()
    }
}