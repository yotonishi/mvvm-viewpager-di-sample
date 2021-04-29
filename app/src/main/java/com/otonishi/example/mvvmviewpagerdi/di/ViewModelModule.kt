package com.otonishi.example.mvvmviewpagerdi.di

import android.content.Context
import com.otonishi.example.mvvmviewpagerdi.data.MySharedPreferences
import com.otonishi.example.mvvmviewpagerdi.data.user.UserRepository
import com.otonishi.example.mvvmviewpagerdi.data.user.local.UserLocalData
import com.otonishi.example.mvvmviewpagerdi.data.user.remote.UserRemoteData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideMySharedPreferences(@ApplicationContext context: Context): MySharedPreferences = MySharedPreferences(context)

    @Provides
    fun provideUserLocalData(
        mySharedPreferences: MySharedPreferences
    ): UserLocalData = UserLocalData(mySharedPreferences)

    @Provides
    fun provideUserRemoteData(
    ): UserRemoteData = UserRemoteData()

    @Provides
    fun provideUserRepository(
        userLocalData: UserLocalData,
        userRemoteData: UserRemoteData
    ): UserRepository = UserRepository(userLocalData, userRemoteData)

}