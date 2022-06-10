package com.nathit.kotlin_retrofit_github

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Model : ViewModel() {

    val title = MutableLiveData<String>("หิวเตี๋ยว")

    fun textClicked() {
        title.value = "เตี๋ยวร้านปิด อดกิน"
    }

}