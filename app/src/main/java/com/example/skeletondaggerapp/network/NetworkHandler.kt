package com.example.skeletondaggerapp.network

import android.content.Context
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides


class NetworkHandler {

    fun isNetworkAvailable(appContext: Context): Boolean{
        val connectivityManager =
            appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo

        return (activeNetworkInfo != null && activeNetworkInfo.isConnected
                && activeNetworkInfo.isAvailable)
    }
}