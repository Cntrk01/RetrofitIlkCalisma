package com.example.retrofitfreecalisma_1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitfreecalisma_1.model.DataClass
import com.example.retrofitfreecalisma_1.service.VeriService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel :ViewModel() {
    val data=MutableLiveData<List<DataClass>>()
    val dataLoading=MutableLiveData<Boolean>()
    val error=MutableLiveData<Boolean>()
    val disposable=CompositeDisposable()
    val veriService=VeriService()


    fun refreshData(){
        getData()
    }

    private fun getData(){
        dataLoading.value=true
        disposable.add(
            veriService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:DisposableSingleObserver<List<DataClass>>(){
                    override fun onSuccess(t: List<DataClass>) {
                        data.value=t
                        error.value=false
                        dataLoading.value=false
                    }

                    override fun onError(e: Throwable) {
                        error.value=true
                        dataLoading.value=false
                        e.printStackTrace()
                    }

                })

        )
    }

}