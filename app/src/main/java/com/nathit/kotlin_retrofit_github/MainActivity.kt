package com.nathit.kotlin_retrofit_github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nathit.kotlin_retrofit_github.databinding.ActivityMainBinding

const val BASE_MAIN_URL = "https://api.github.com"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.viewModel = Model()
        binding.lifecycleOwner = this@MainActivity


    }
}