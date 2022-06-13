package com.nathit.kotlin_retrofit_github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nathit.kotlin_retrofit_github.databinding.ActivityMainBinding

const val BASE_URL = "https://api.github.com"

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val emojiFragment = EmojiFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = Model()
        binding.lifecycleOwner = this@MainActivity

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_user -> replaceFragment(homeFragment)
                R.id.nav_emoji -> replaceFragment(emojiFragment)
            }
            true
        }

        replaceFragment(homeFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragment)
            transaction.commit()
        }
    }
}