package com.example.e_commerce.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.dataclass.data
import com.example.e_commerce.repository.dataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(private val respository : dataRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            respository.getData("en","KWD")
        }
    }

    val data : LiveData<data>
        get() = respository.data

}