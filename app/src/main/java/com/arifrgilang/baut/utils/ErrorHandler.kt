/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:34 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:34 AM
 *
 */

package com.arifrgilang.baut.utils

import android.util.Log
import com.arifrgilang.baut.base.BaseException
import retrofit2.HttpException

class ErrorHandler {
    companion object {

        fun handleError(throwable: Throwable?): String {
            Log.d("zzz","error handler")
            Logger.log(throwable)

            if (throwable == null) {
                Log.d("Connection", "Error device network")
                return "Please check your network and try again."
            }
            if (throwable is BaseException) {

                val rameException = throwable as BaseException?
                val baseResponse = rameException!!.response
                if (baseResponse != null) {
                    val message = baseResponse.message
                    if (message != null && !message.isEmpty()) {
                        Log.d("Connection", "Error other: $message")
                        return message
                    } else {
                        return "Please check your network and try again."
                    }
                }
            }

            if (throwable is HttpException) {
                val httpException = throwable as HttpException?
                if (httpException!!.code() == 403 || httpException.code() == 401) {
                    forceLogout()
                    Log.d("Connection", "Error Permission")
                    return "Please logout then re login"
                }
            }
            Log.d("Connection", "Untracked error")
            //        Crashlytics.logException(throwable);
            return "Please check your network and try again."
        }

        private fun forceLogout() {

        }
    }

}