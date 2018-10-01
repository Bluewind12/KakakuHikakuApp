package com.example.momoproject.kakakuhikaku

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import android.view.inputmethod.InputMethodManager


class MainActivity : AppCompatActivity() {

    val AMAZON_URL = "https://www.amazon.co.jp/gp/aw/s/ref=nb_sb_noss?k="
    val RAKUTEN_URL = "https://search.rakuten.co.jp/search/mall/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        backAmazon.visibility = View.INVISIBLE
        backRakuten.visibility = View.INVISIBLE
        oneViewMode1.visibility = View.INVISIBLE
        oneViewMode2.visibility = View.INVISIBLE

        searchButton.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)

            val editString = editText.text
            val searchAmazon = AMAZON_URL + editString
            val searchRakuten = RAKUTEN_URL + editString

            //Amazonページ
            webAmazon.webViewClient = WebViewClient()
            webAmazon.loadUrl(searchAmazon)
            //楽天ページ
            webRakuten.webViewClient = WebViewClient()
            webRakuten.loadUrl(searchRakuten)

            backAmazon.visibility = View.VISIBLE
            backRakuten.visibility = View.VISIBLE
            oneViewMode1.visibility = View.VISIBLE
            oneViewMode2.visibility = View.VISIBLE
        }

        backAmazon.setOnClickListener {
            webAmazon.goBack()
        }
        backRakuten.setOnClickListener {
            webRakuten.goBack()
        }

        oneViewMode1.setOnClickListener {
            val setUrl = webAmazon.url
            val intent = Intent(this, oneViewModeActivity::class.java)
            intent.putExtra("URL", setUrl)
            startActivity(intent)
        }
        oneViewMode2.setOnClickListener {
            val setUrl = webRakuten.url
            val intent = Intent(this, oneViewModeActivity::class.java)
            intent.putExtra("URL", setUrl)
            startActivity(intent)

        }
    }
}
