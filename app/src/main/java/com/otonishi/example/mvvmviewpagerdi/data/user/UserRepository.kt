package com.otonishi.example.mvvmviewpagerdi.data.user

import com.otonishi.example.mvvmviewpagerdi.data.entities.GithubUser
import com.otonishi.example.mvvmviewpagerdi.data.user.local.UserLocalDataSource
import com.otonishi.example.mvvmviewpagerdi.data.user.remote.UserRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : UserDataSource {

    override var name: String
        get() = userLocalDataSource.name
        set(value) {
            userLocalDataSource.name = value
        }

    override suspend fun onGetGithubUser(
        atSuccess: (GithubUser) -> Unit,
        atError: (Throwable) -> Unit
    ) {
        userRemoteDataSource.onGetGithubUser(atSuccess, atError)
    }

}