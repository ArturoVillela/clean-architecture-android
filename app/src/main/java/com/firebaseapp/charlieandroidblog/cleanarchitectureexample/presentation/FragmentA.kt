package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.R
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.ResponseServer
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.presentation.recyclerviews.UsersAdapter
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.presentation.viewmodels.FragmentAViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class FragmentA : Fragment() {
    // TODO: Rename and change types of parameters

//    var fa_viewmodel: ViewModel by lazy {
//        ViewModelProvider(this).get(FragmentAViewModel::class.java)
//    }
   // private val viewModel = ViewModelProvider(this).get(FragmentAViewModel::class.java)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_a, container, false)
        val vm = ViewModelProvider(this).get(FragmentAViewModel::class.java)
        var fragContext = activity

        val btn = view.findViewById<Button>(R.id.button_fa)
        btn.setOnClickListener {
            vm.initRestCall()
        }

        val rv = view.findViewById<RecyclerView>(R.id.rv_container)
        var linearLayoutManager = LinearLayoutManager(fragContext)
        rv.layoutManager = linearLayoutManager


        vm._listUsers.observe(viewLifecycleOwner, Observer {
            val cantUsers = vm._listUsers.value?.size
            Toast.makeText(this.context,"success, users:"+cantUsers,Toast.LENGTH_SHORT).show()
            fragContext?.let {
                var adapter = UsersAdapter(vm.getListUsers()!!,it)
                adapter?.notifyDataSetChanged()
                rv.adapter = adapter
            }

        })


        return view
    }

    private suspend fun updateUI(value: ResponseServer, view: View) {
        withContext(Dispatchers.Main){  //cambiamos la ejecucion al ui thread
           // view.findViewById<TextView>(R.id.textView2).text = value.valueObtained
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}