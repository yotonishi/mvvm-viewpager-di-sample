package com.otonishi.example.mvvmviewpagerdi.data.user.local

import com.otonishi.example.mvvmviewpagerdi.data.MySharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalData @Inject constructor(
    private val mySharedPreferences: MySharedPreferences
) : UserLocalDataSource {

    override var name: String
        get() = mySharedPreferences.name
        set(value) {
            mySharedPreferences.name = value
        }
}
