package com.example.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.e_commerce.api.apiInterface
import com.example.e_commerce.api.retrofit
import com.example.e_commerce.databinding.ActivityMainBinding
import com.example.e_commerce.repository.dataRepository
import com.example.e_commerce.viewmodels.ViewModel
import com.example.e_commerce.viewmodels.ViewModelFactory


class MainActivity : AppCompatActivity() {

    lateinit var viewmodel: ViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = retrofit.getInstance().create(apiInterface::class.java)
        val repository = dataRepository(data)

        viewmodel = ViewModelProvider(this, ViewModelFactory(repository)).get(ViewModel::class.java)

        viewmodel.data.observe(this, Observer {
            Log.d("CheckData", it.data.description)
            val description = repository.data.value?.data?.description
            binding.description.text = "$description"

            val sku = repository.data.value?.data?.sku
            binding.skudetails.text = "$sku"

            val name = repository.data.value?.data?.name
            binding.textView3.text = "$name"
           
 Glide.with(this).load(repository.data.value?.data?.image).into(binding.imageView)

            Glide.with(this).load(repository.data.value?.data?.image).into(binding.imageView6)

            Glide.with(this).load(repository.data.value?.data?.image).into(binding.imageView8)

            Glide.with(this).load(repository.data.value?.data?.image).into(binding.imageView9)

            Glide.with(this).load(repository.data.value?.data?.image).into(binding.imageView10)

            Glide.with(this).load(repository.data.value?.data?.image).into(binding.imageView11)

            Glide.with(this).load(repository.data.value?.data?.image).into(binding.imageView12)
        })
    }
}