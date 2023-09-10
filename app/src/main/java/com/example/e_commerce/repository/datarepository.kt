package com.example.e_commerce.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e_commerce.api.apiInterface
import com.example.e_commerce.dataclass.data

class dataRepository(private val apiInterface: apiInterface) {

    private val dataLiveData = MutableLiveData<data>()

    val data : LiveData<data>
        get() = dataLiveData

    suspend fun getData(lang : String, store : String){
        val result = apiInterface.getData(lang, store)
        if (result?.body() != null){
            dataLiveData.postValue(result.body())
        }
    }
}