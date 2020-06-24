package com.inguraga.examengapsi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.inguraga.examengapsi.model.Record
import com.inguraga.examengapsi.repo.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import okhttp3.ResponseBody
import retrofit2.Response

class MainViewModel(private val mainRepository: MainRepository) : ViewModel(),
    MainRepository.OnRequestFinishedListener{

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _showMessageError = MutableLiveData<String>()
    val showMessageError: LiveData<String>
        get() = _showMessageError

    private var _products = MutableLiveData<List<Record>>()
    val product : LiveData<List<Record>>
        get() = _products

    fun searchProducts(text:String,paging:Int, noItems:Int){
        mainRepository.searchProduct(text,paging,noItems,this)
    }

    override fun onSuccess(response: List<Record>) {
        _products.value = response
    }

    override fun onError(message: String?) {
        _showMessageError.value = message
    }
}

class MainViewModelFactory(private val mainRepository: MainRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainRepository) as T
    }
}