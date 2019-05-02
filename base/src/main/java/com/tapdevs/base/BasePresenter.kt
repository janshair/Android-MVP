package com.tapdevs.base

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<T> () {
    private val disposables = CompositeDisposable()
    protected var view: T? = null

    val isViewAttached: Boolean
        get() = view != null

    /**
     * On view attached. To be called when your view is initialised.
     *
     * @param view View attached to the presenter
     */
    @CallSuper
    open fun onViewAttached(view: T) {
        if (isViewAttached) {
            throw IllegalStateException(
                    "View " + this.view + " is already attached. Cannot attach " + view)
        }
        this.view = view
    }

    /**
     * On view detached. Intended as a cleanup process that should be called when the view will no
     * longer be in use.
     */
    @CallSuper
    fun onViewDetached() {
        if (!isViewAttached) {
            throw IllegalStateException("View is already detached")
        }
        view = null
        disposables.clear()
    }

    /**
     * Dispose on view detach.
     *
     * @param disposable Disposable to be disposed of upon view detachment
     */
    @CallSuper
    protected fun disposeOnViewDetach(disposable: Disposable) {
        disposables.add(disposable)
    }
}