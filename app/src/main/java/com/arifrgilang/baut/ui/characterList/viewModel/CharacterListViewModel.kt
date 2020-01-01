/*
 * *
 *  * Created by Arif R. Gilang on 12/30/19 3:58 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/30/19 3:58 PM
 *
 */

package com.arifrgilang.baut.ui.characterList.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arifrgilang.baut.base.BaseViewModel
import com.arifrgilang.baut.data.local.db.CharacterDatabase
import com.arifrgilang.baut.data.model.ArrayResponse
import com.arifrgilang.baut.data.model.CharacterModel
import com.arifrgilang.baut.utils.AppUtils
import com.arifrgilang.baut.utils.SharedPreferenceHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class CharacterListViewModel(application: Application) : BaseViewModel(application) {
    private var prefHelper = SharedPreferenceHelper(getApplication())
    private var refreshTime = AppUtils.getRefreshTime()

    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Boolean>()
    val list = MutableLiveData<List<CharacterModel>>()

    private val disposable = CompositeDisposable()

    fun refresh(){
        val updateTime = prefHelper.getUpdateTime()
        if(updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime){
            fetchFromDatabase()
        }else{
            fetchFromRemote()
        }
    }

    fun refreshBypassCache(){
        fetchFromRemote()
    }

    private fun fetchFromDatabase() {
        isLoading.value = true
        launch {
            Log.d("CharacterListViewModel", "Fetched From RoomDB")
            val listData = CharacterDatabase(getApplication()).dao().getAllCharacter()
            setList(listData)
        }
    }

    private fun fetchFromRemote() {
        isLoading.value = true
        isError.value = false
        disposable.add(
            dataManager.getAllCharacter()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<ArrayResponse<CharacterModel>>(){
                    override fun onSuccess(t: ArrayResponse<CharacterModel>) {
                        Log.d("response", t.results.toString())
                        t.results?.let {
                            Log.d("responseSize", it.size.toString())
                            saveLocally(it)
                        }
                        isLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        isError.value = true
                        isLoading.value = false
                        e.printStackTrace()
                    }
                })
        )
    }

    private fun saveLocally(data: List<CharacterModel>) {
        launch {
            val dao = CharacterDatabase(getApplication()).dao()
            dao.deleteAllCharacter()
            dao.insertAll(data)
            setList(data)
        }
        prefHelper.saveUpdateTime(System.nanoTime())
    }

    private fun setList(data: List<CharacterModel>) {
        list.value = data
        isLoading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}