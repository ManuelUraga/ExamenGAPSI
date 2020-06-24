package com.inguraga.examengapsi.repo

import com.inguraga.examengapsi.model.Product
import com.inguraga.examengapsi.model.Record
import com.inguraga.examengapsi.repo.api.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    interface OnRequestFinishedListener {
        fun onSuccess(response: List<Record>)
        fun onError(message: String?)
    }

    fun searchProduct(text:String,paging:Int,noItems:Int,listener: OnRequestFinishedListener){
        Api().searchProduct(true,text,paging,noItems)?.enqueue(object: Callback<Product>{
                override fun onFailure(call: Call<Product>, t: Throwable) {
                    listener.onError(t.message)
                }
                override fun onResponse(call: Call<Product>, response: Response<Product>){
                    response.let {
                        if (it.isSuccessful){
                            listener.onSuccess(it.body()?.plpResults?.records!!)
                        }else{
                            listener.onError(response.errorBody()?.string())
                        }
                    }
                }
            })
    }
}