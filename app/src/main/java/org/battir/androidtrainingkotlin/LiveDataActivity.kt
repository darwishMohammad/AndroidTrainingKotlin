package org.battir.androidtrainingkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.battir.androidtrainingkotlin.Adapters.RecyclerViewAdapter
import org.battir.androidtrainingkotlin.databinding.ActivityLiveDataBinding
import org.battir.androidtrainingkotlin.model.MainViewModel
import org.battir.androidtrainingkotlin.model.User

class LiveDataActivity : AppCompatActivity(), LifecycleOwner {
    //Our instance properties
    var viewModel: MainViewModel? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: RecyclerViewAdapter? = null
    //ViewBinding will generate us a class based on our layout name
    private lateinit var binding: ActivityLiveDataBinding
    //Users live data
    var userListUpdateObserver: Observer<ArrayList<User>?> =
        Observer<ArrayList<User>?> { userArrayList ->
            recyclerViewAdapter = RecyclerViewAdapter(this@LiveDataActivity, userArrayList)
            recyclerView!!.layoutManager = LinearLayoutManager(this@LiveDataActivity)
            recyclerView!!.adapter = recyclerViewAdapter
        }
    //Override oncreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate our layout via Viewbinding
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
        //set contentview
        setContentView(binding.root)
        //reference recylerview
        recyclerView = binding.rvMain

        //initialize our Viewmodel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //observe our users livedata
        viewModel?.userMutableLiveData?.observe(this, userListUpdateObserver)
    }

}
//end