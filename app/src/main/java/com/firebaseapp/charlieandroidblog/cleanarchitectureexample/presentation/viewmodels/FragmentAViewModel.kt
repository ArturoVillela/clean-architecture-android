package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.ResponseServer
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.User
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.usecases.UseCaseNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FragmentAViewModel @Inject constructor(
    private val useCaseNetwork: UseCaseNetwork
) :ViewModel() {


    private var listUsers = MutableLiveData<List<User>>()
    var _listUsers = listUsers

    fun getListUsers():List<User>? = _listUsers.value


    fun initRestCall(){
        //Direct call
        val scope = viewModelScope
        useCaseNetwork.initUsersCalls(_listUsers, scope)
    }

    //Faking rest service
//    private fun initRestServiceValidator() {
//
//        viewModelScope.launch {
//            delay(5000)
//            val randomBoolean = if (Random.nextInt(0, 2) == 0) false else true
//            val info = if (randomBoolean) "error" else "cadena X del server."
//            val res = ResponseServer(randomBoolean,info)
//            Log.d("zzzz", "responded in server.: ")
//
//           // stateResponse.value =  res
//        }
//    }
}