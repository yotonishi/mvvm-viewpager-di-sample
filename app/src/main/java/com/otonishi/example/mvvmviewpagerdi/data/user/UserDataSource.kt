package com.otonishi.example.mvvmviewpagerdi.data.user

import com.otonishi.example.mvvmviewpagerdi.data.user.local.UserLocalDataSource
import com.otonishi.example.mvvmviewpagerdi.data.user.remote.UserRemoteDataSource

interface UserDataSource : UserLocalDataSource, UserRemoteDataSource