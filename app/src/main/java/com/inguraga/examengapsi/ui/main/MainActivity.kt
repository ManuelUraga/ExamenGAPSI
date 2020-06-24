package com.inguraga.examengapsi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.inguraga.examengapsi.R
import com.inguraga.examengapsi.databinding.ActivityMainBinding
import com.inguraga.examengapsi.repo.MainRepository
import com.inguraga.examengapsi.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var adapter: ProductAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProviders.of(this,
            MainViewModelFactory(MainRepository()))[MainViewModel::class.java]

        adapter = ProductAdapter()
        binding.rvProducts.adapter = adapter

        initObserver()

        imgBSearch.setOnClickListener {
            if (etSearchProduct.text.isNotEmpty()){
                viewModel.searchProducts(etSearchProduct.text.toString(),1,5)
            }else{
                Toast.makeText(this,"Campo vacio",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initObserver(){
        viewModel.showMessageError.observe(this, Observer {
            toast(it)
        })

        viewModel.product.observe(this, Observer {
            adapter.submitList(it)
        })
    }

}