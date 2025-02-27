package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.usecases

import androidx.lifecycle.MutableLiveData
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.User
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.network.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class UseCaseNetwork @Inject constructor(
    private val userRepository: UserRepository
) {


    fun initUsersCalls(_listUsers: MutableLiveData<List<User>>, scope: CoroutineScope) {
          scope.launch {
             val wrapperResponse = userRepository.getUsers()
             if (wrapperResponse.sucessCall){
                _listUsers.value = wrapperResponse.listUsers
             }
          }

    }


}

/*
class FragmentAViewModel @Inject constructor(  //need to be accompanied by this anotation
   private val userRepository: UserRepository
)
 */