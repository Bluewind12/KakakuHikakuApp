package com.example.momoproject.kakakuhikaku

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.setting_layout.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingData = getSharedPreferences("SettingData", Context.MODE_PRIVATE)
        val edit = settingData.edit()

        settingData.getString("UP_URL", "https://www.amazon.co.jp/gp/aw/s/ref=nb_sb_noss?k=")
        settingData.getString("DOWN_URL", "https://search.rakuten.co.jp/search/mall/")

        settingEnterButton.setOnClickListener {

        }

        resetButton.setOnClickListener {

        }
    }
}