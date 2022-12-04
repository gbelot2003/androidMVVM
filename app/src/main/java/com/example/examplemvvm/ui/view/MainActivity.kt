package com.example.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer{currentCuote ->
            binding.tcQuote.text = currentCuote.Quote
            binding.tvAuthor.text = currentCuote.Author
        })

        quoteViewModel.isLoading.observe(this, Observer{
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener{ quoteViewModel.randomQuote() }
    }
}