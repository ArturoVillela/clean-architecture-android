package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.network

import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.User

data  class WrapperResponse (
    val sucessCall:Boolean,
    val errorNumberIfAny : Int = 0,
    val listUsers : List<User>? = null
)