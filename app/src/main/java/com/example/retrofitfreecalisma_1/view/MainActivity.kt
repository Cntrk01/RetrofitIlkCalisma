package com.example.retrofitfreecalisma_1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitfreecalisma_1.R
import com.example.retrofitfreecalisma_1.adapter.recycleAdapter
import com.example.retrofitfreecalisma_1.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var RecyclerAdapter=recycleAdapter(arrayListOf())
    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.refreshData()
        besinListRecycler.layoutManager=LinearLayoutManager(this)
        besinListRecycler.adapter=RecyclerAdapter

        observe()
    }

    private fun observe(){
        viewModel.data.observe(this, Observer {
            it?.let {
                besinListRecycler.visibility= View.VISIBLE
                RecyclerAdapter.dataUpdate(it)
            }
        })
        viewModel.error.observe(this, Observer {
            it?.let{
                if(it){
                    besinHataMesaji.visibility=View.VISIBLE
                }else{
                    besinHataMesaji.visibility=View.GONE
                }
            }
        })
        viewModel.dataLoading.observe(this, Observer {
            it?.let {
                if(it){
                    besinListRecycler.visibility=View.GONE
                    besinHataMesaji.visibility=View.GONE
                    besinYukleniyor.visibility=View.VISIBLE
                }else{
                    besinYukleniyor.visibility=View.GONE
                }
            }
        })
    }



}