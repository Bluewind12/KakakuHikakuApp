package com.example.momoproject.kakakuhikaku

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.setting_layout.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_layout)

        val settingData = getSharedPreferences("SettingData", Context.MODE_PRIVATE)
        val edit = settingData.edit()

        upEditText.setText(settingData.getString("UP_URL", "https://www.amazon.co.jp/gp/aw/s/ref=nb_sb_noss?k="), TextView.BufferType.NORMAL)
        downEditText.setText(settingData.getString("DOWN_URL", "https://search.rakuten.co.jp/search/mall/"), TextView.BufferType.NORMAL)

        settingEnterButton.setOnClickListener {
            edit.putString("UP_URL", upEditText.text.toString())
            edit.putString("DOWN_URL", downEditText.text.toString())
            edit.apply()
        }

        resetButton.setOnClickListener {
            upEditText.setText("https://www.amazon.co.jp/gp/aw/s/ref=nb_sb_noss?k=", TextView.BufferType.NORMAL)
            downEditText.setText("https://search.rakuten.co.jp/search/mall/", TextView.BufferType.NORMAL)
        }
    }
}