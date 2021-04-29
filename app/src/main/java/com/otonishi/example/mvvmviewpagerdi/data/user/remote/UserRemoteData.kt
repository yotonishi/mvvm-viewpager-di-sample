package com.otonishi.example.mvvmviewpagerdi.data.user.remote

import com.google.gson.Gson
import com.otonishi.example.mvvmviewpagerdi.data.entities.GithubUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRemoteData @Inject constructor(
) : UserRemoteDataSource {

    override suspend fun onGetGithubUser(
        atSuccess: (GithubUser) -> Unit,
        atError: (Throwable) -> Unit
    ) {

        try {
            val url = "https://api.github.com/users/yotonishi"
            val request = Request.Builder().url(url).build()
            withContext(Dispatchers.IO) {
                val response= OkHttpClient().newCall(request).execute()
                // body?.string() is once only
                val str = response.body?.string()
                if (str.isNullOrEmpty()) {
                    atError(Exception("Github Failed"))
                } else {
                    atSuccess(Gson().fromJson(str, GithubUser::class.java))
                }
            }
        } catch (e: Throwable) {
            atError(e)
        }
    }

}