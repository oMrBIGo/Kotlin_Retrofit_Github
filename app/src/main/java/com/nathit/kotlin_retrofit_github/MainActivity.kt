package com.nathit.kotlin_retrofit_github

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nathit.kotlin_retrofit_github.Activity.AllEmojiActivity
import com.nathit.kotlin_retrofit_github.Activity.AllEventsActivity
import com.nathit.kotlin_retrofit_github.Activity.AllGistsActivity
import com.nathit.kotlin_retrofit_github.Activity.AllUsersActivity
import com.nathit.kotlin_retrofit_github.databinding.ActivityMainBinding

const val BASE_URL = "https://api.github.com"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = Model()
        binding.lifecycleOwner = this@MainActivity

        binding.btnUser.setOnClickListener {
            startActivity(Intent(this,AllUsersActivity::class.java))
        }

        binding.btnEmojis.setOnClickListener {
            val intent = Intent(this, AllEmojiActivity::class.java)
            startActivity(intent)
        }

        binding.btnEvents.setOnClickListener {
            val intent = Intent(this, AllEventsActivity::class.java)
            startActivity(intent)

        }

        binding.btnGists.setOnClickListener {
            val intent = Intent(this, AllGistsActivity::class.java)
            startActivity(intent)
        }

    }
}