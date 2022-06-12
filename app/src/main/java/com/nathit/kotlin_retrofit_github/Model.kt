package com.nathit.kotlin_retrofit_github

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Model : ViewModel() {

    //MainActivity
    val title = MutableLiveData<String>("ยินดีต้อนรับเข้าสู่ GitHub ก็อปเกรด A ^_^")
    val btnUser = MutableLiveData<String>("ผู้ใช้งาน")
    val btnEmojis = MutableLiveData<String>("อีโมจิ")
    val btnEvents = MutableLiveData<String>("กิจกรรม")
    val btnGists = MutableLiveData<String>("กระทู้")

    //AllUsersActivity
    val btnHtml = MutableLiveData<String>("ไปที่เว็บไซต์")

}