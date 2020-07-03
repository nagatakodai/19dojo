package com.nkjp.a19dojo_kotlin

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview)

        val uri = intent.getStringExtra("FLAG")
        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.loadUrl(uri)
    }
}