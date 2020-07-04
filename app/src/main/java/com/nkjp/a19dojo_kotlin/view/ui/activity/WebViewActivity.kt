package com.nkjp.a19dojo_kotlin.view.ui.activity

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.nkjp.a19dojo_kotlin.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview)

        val uri = intent.getStringExtra("FLAG")
        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.loadUrl(uri)
    }
}