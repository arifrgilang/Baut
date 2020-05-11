/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:36 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:36 AM
 *
 */

package com.arifrgilang.baut.utils

import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RxUtils {
    fun <T> applyApiCall(): SingleTransformer<T, T> {
        return SingleTransformer { tObservable ->
            tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    it.printStackTrace()
                }
                .onErrorResumeNext { throwable: Throwable ->
                    throwable.printStackTrace()
                    return@onErrorResumeNext Single.error(throwable)
                }
                .flatMap { res ->
                    if (res == null){
                        return@flatMap Single.error<T>(NullPointerException())
                    } else {
                        return@flatMap Single.just(res)
                    }
                }
        }
    }
}