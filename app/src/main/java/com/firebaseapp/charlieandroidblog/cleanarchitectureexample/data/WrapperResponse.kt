package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data

data  class WrapperResponse (
    val sucessCall:Boolean,
    val errorNumberIfAny : Int = 0,
    val listUsers : List<User>? = null
)