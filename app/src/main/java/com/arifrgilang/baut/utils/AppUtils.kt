/*
 * *
 *  * Created by Arif R. Gilang on 12/27/19 7:32 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/27/19 7:32 AM
 *
 */

package com.arifrgilang.baut.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.DecimalFormat

object AppUtils {
    private val PLAY_SERVICES_RESOLUTION_REQUEST = 9000
    //    public static TextDrawable getTextDrawable(Context context, String name){
    //        return TextDrawable.builder()
    //                .buildRound(name.substring(0,1), ContextCompat.getColor(context, R.color.colorPrimaryDark));
    //    }
    private val MY_PERMISSIONS_REQUEST = 500

    fun defaultLinearLayoutManager(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    fun horizontalLinearLayoutManager(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    }

    fun gridLayoutManager(context: Context, rows: Int): GridLayoutManager {
        return GridLayoutManager(context, rows)
    }

    fun isEmailValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex()) && email.length > 0
    }

    fun isPhoneValid(phoneNumber: String): Boolean{
        if(isNullOrEmpty(phoneNumber)){
            return false
        }else return phoneNumber.length in 8..15
    }

    fun getRate(aDouble: Double): String {
        return DecimalFormat("##.#").format(aDouble)
    }


    fun isNullOrEmpty(string: String?): Boolean {
        return if (string == null) {
            true
        } else string.isEmpty()
    }

    private fun checkReadWritePermission(activity: Activity): Boolean {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                MY_PERMISSIONS_REQUEST
            )
            return false
        } else {
            return true
        }
    }

    fun checkLocationPermission(activity: Activity): Boolean {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                MY_PERMISSIONS_REQUEST
            )
            return false
        } else {
            return true
        }
    }

    fun checkCameraPermission(activity: Activity): Boolean {
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                arrayOf(Manifest.permission.CAMERA),
                MY_PERMISSIONS_REQUEST
            )
            return false
        } else {
            return true
        }
    }

    fun getMoneyFormat(money: Int?): String {
        val formatter = DecimalFormat("#,###")
        return if (money == 0) {
            ""
        } else "Rp " + formatter.format(money)
    }

    fun millisToMinute(millis: Int): Int{
        return (millis / 1000) / 60
    }

    fun millisToSecond(millis: Int): Int{
        return (millis / 1000) % 60
    }

    fun getRefreshTime(): Long{
        return 5 * 60 * 1000 * 1000 * 1000L //5 minute in Nano second
    }
}