package com.shaadidemo.view.viewmodel

import androidx.lifecycle.ViewModel
import com.shaadidemo.domain.di.DaggerDomainComponent
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    protected var dataRepository = DaggerDomainComponent.builder().build().getDataRepo()
    protected var compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}