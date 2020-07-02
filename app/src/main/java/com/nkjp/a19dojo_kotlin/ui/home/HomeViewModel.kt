package com.nkjp.a19dojo_kotlin.ui.home

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.util.AndroidRuntimeException
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nkjp.a19dojo_kotlin.R
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

}