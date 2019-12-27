/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:21 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:21 AM
 *
 */

package com.arifrgilang.baut.utils

import android.util.Log
import com.arifrgilang.baut.BuildConfig
import com.arifrgilang.baut.data.remote.ApiServices
import com.arifrgilang.baut.data.remote.DataManager
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
import java.net.SocketException
import java.util.concurrent.TimeUnit

class AppShared {
    companion object {
        fun dataManager() : DataManager {
            if (this.dataManager == null) {
                dataManager = DataManager(getServiceInstance(BuildConfig.BASE_URL, ApiServices::class.java))
            }
            return dataManager!!
        }

        private var dataManager : DataManager? = null

        private fun <T> getServiceInstance(url : String, serviceClass: Class<T>) : T {
            val interceptor = HttpLoggingInterceptor { message -> Log.d("http", message) }
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                .writeTimeout(25, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .connectTimeout(25, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor { chain ->
                    val request = chain.request()
                    try {
                        return@addInterceptor chain.proceed(request)
                    } catch (e: Exception) {
                        return@addInterceptor Response.Builder()
                            .request(request)
                            .code(408)
                            .protocol(Protocol.HTTP_1_1)
                            .message("{\"status\":\"fail\",\"description\":\"Please check your connection\"}")
                            .body(
                                ResponseBody.create(
                                    "application/json".toMediaTypeOrNull(),
                                    "{\"status\":\"fail\",\"description\":\"Please check your connection\"}"
                                )
                            )
                            .build()
                    }
                }
                .addNetworkInterceptor { chain ->
                    val request = chain.request()

                    val newRequest = request.newBuilder()
                        .addHeader("Cache-Control", "no-cache")
                        .addHeader("Cache-Control", "no-store")
                        .build()
                    try {
                        return@addNetworkInterceptor chain.proceed(newRequest)
                    } catch (e: SocketException) {
                        e.printStackTrace()
                        return@addNetworkInterceptor chain.proceed(chain.request())
                    }
                }.build()

            val gson = GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(serviceClass)
        }
    }
}