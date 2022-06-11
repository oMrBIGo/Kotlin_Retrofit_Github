package com.nathit.kotlin_retrofit_github

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nathit.kotlin_retrofit_github.databinding.ActivityMainBinding

const val BASE_USERS_URL = "https://api.github.com/users"
const val BASE_EMOJIS_URL = "https://api.github.com/emojis"
const val BASE_EVENT_URL = "https://api.github.com/events"
const val BASE_GISTS_URL = "https://api.github.com/gists"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.viewModel = Model()
        binding.lifecycleOwner = this@MainActivity

        binding.btnUser.setOnClickListener {
            val intent = Intent(this, AllUsersActivity::class.java)
            intent.putExtra("user_url",BASE_USERS_URL)
            startActivity(intent)
        }

        binding.btnEmojis.setOnClickListener {
           val intent = Intent(this, AllEmojiActivity::class.java)
            intent.putExtra("emoji_url",BASE_EMOJIS_URL)
            startActivity(intent)
        }

        binding.btnEvents.setOnClickListener {

        }

        binding.btnGists.setOnClickListener {

        }

    }
}