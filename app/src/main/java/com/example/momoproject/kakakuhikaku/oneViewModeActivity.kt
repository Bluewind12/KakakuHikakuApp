package com.example.momoproject.kakakuhikaku

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.one_view_layout.*

class oneViewModeActivity : AppCompatActivity() {
    var setUrl: String = "404"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_view_layout)
        setUrl = intent.getStringExtra("URL")

        oneModeWebView.webViewClient = WebViewClient()
        oneModeWebView.loadUrl(setUrl)

        oneBackButton.setOnClickListener {
            oneModeWebView.goBack()
        }
        reloadButton.setOnClickListener {
            oneModeWebView.reload()
        }

    }
}