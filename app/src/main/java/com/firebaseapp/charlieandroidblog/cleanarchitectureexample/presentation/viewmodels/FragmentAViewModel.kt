package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.ResponseServer
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.User
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel //indicate we will inject something in the constructor
class FragmentAViewModel @Inject constructor(  //need to be accompanied by this anotation
    val userRepository: UserRepository
)   :ViewModel() {
//@HiltViewModel
//class FragmentAViewModel:ViewModel() {

//    @Inject
//    @Named("repository")
//    lateinit var userRepository: UserRepository

    //var stateResponse : StateFlow<ResponseServer> = MutableStateFlow(ResponseServer())
    //var uiState:StateFlow<ResponseServer> = stateResponse
    private var listUsers = MutableLiveData<List<User>>()
    var _listUsers = listUsers


    fun initRestCall(){
        //Direct call
        viewModelScope.launch {
            val wrapperResponse = userRepository.getUsers()
            if (wrapperResponse.sucessCall)
                _listUsers.value = wrapperResponse.listUsers
        }
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