package com.otonishi.example.mvvmviewpagerdi.data.user.remote

import com.otonishi.example.mvvmviewpagerdi.data.entities.GithubUser


interface UserRemoteDataSource {

    suspend fun onGetGithubUser(
        atSuccess: (GithubUser) -> Unit,
        atError: (Throwable) -> Unit
    )
}
