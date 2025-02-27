package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data

import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.network.UsersApi
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.network.WrapperResponse
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class UserRepository @Inject constructor() {

    suspend fun getUsers(): WrapperResponse {

        lateinit var wrapper : WrapperResponse

        val apiCall = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsersApi::class.java)

        val res = apiCall.getRepoUsers(Const.END_URL).awaitResponse()

        if (res.isSuccessful)
            wrapper = WrapperResponse(true,0,res.body()?.users)
        else
            wrapper = WrapperResponse(false,200)

        return wrapper
    }
}