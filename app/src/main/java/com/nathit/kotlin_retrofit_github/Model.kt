package com.nathit.kotlin_retrofit_github

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Model : ViewModel() {

    //MainActivity
    val title = MutableLiveData<String>("Welcome to GitHub")
    val btnUser = MutableLiveData<String>("AllUsers")
    val btnEmojis = MutableLiveData<String>("AllEmojis")
    val btnEvents = MutableLiveData<String>("AllEvents")
    val btnGists = MutableLiveData<String>("AllGists")

    fun btnUserClicked() {
        btnUser.value = "Loading..."
    }

    fun btnEmojisClicked() {
        btnEmojis.value = "Loading..."
    }

    fun btnEventsClicked() {
        btnEvents.value = "Loading..."
    }

    fun btnGistsClicked() {
        btnGists.value = "Loading..."
    }

}