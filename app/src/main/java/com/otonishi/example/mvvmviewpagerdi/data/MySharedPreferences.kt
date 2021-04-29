package com.otonishi.example.mvvmviewpagerdi.data

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MySharedPreferences @Inject constructor(
    private val context: Context
) {

    private val Context.sharedPreferences: SharedPreferences
        get() = getSharedPreferences("otonishi_setting", Context.MODE_PRIVATE)

    var name: String
        get() = context.sharedPreferences.getString("input_name", "") ?: ""
        set(name) = context.sharedPreferences.edit().putString("input_name", name).apply()
}