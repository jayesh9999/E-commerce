package com.example.e_commerce.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_commerce.repository.dataRepository

class ViewModelFactory(private val repository : dataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return com.example.e_commerce.viewmodels.ViewModel(repository) as T
    }
}