package com.example.momoproject.kakakuhikaku

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import android.view.inputmethod.InputMethodManager
import android.R.menu
import android.app.Activity
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    val AMAZON_URL = "https://www.amazon.co.jp/gp/aw/s/ref=nb_sb_noss?k="
    val RAKUTEN_URL = "https://search.rakuten.co.jp/search/mall/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //最初は非表示
        backAmazon.visibility = View.INVISIBLE
        backRakuten.visibility = View.INVISIBLE
        oneViewMode1.visibility = View.INVISIBLE
        oneViewMode2.visibility = View.INVISIBLE

        //キーボード表示を制御するためのオブジェクト
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        //EditTextにリスナーをセット
        editText.setOnKeyListener(object : View.OnKeyListener {
            //コールバックとしてonKey()メソッドを定義
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
                //イベントを取得するタイミングには、ボタンが押されてなおかつエンターキーだったときを指定
                if (event.getAction() === KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    //キーボードを閉じる
                    inputMethodManager.hideSoftInputFromWindow(editText.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
                    searchFunction()
                    return true
                }

                return false
            }
        })

        //戻るボタンの処理
        backAmazon.setOnClickListener {
            webAmazon.goBack()
        }
        backRakuten.setOnClickListener {
            webRakuten.goBack()
        }

        //一画面モードボタンの処理
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

   override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_menu1 -> {
                startActivity(Intent(this, SettingActivity::class.java))
                return true
            }
        }
        return true
    }

    fun searchFunction() {
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
}
