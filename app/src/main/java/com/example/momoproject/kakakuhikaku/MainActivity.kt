package com.example.momoproject.kakakuhikaku

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val AMAZON_URL = "https://www.amazon.co.jp/s/field-keywords="
    val RAKUTEN_URL = "https://search.rakuten.co.jp/search/mall/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        searchButton.setOnClickListener {
            val editString = editText.text
            val serchAmazon = AMAZON_URL + editString
            val serchRakuten = RAKUTEN_URL + editString

            //Amazonページ
            webAmazon.webViewClient = WebViewClient()
            webAmazon.loadUrl(serchAmazon)
            //楽天ページ
            webRakuten.webViewClient = WebViewClient()
            webRakuten.loadUrl(serchRakuten)
        }
    }
}
