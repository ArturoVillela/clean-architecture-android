package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.network

import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.ResponseUsers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface UsersApi {

    @GET
    fun getRepoUsers(@Url url: String) : Call<ResponseUsers>

}