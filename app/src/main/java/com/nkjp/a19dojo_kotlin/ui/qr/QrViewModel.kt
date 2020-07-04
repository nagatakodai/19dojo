package com.nkjp.a19dojo_kotlin.ui.qr

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.zxing.BarcodeFormat
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.nkjp.a19dojo_kotlin.R
import kotlinx.coroutines.launch

class QrViewModel : ViewModel() {

    val bitmap: MutableLiveData<Bitmap> by lazy {
        MutableLiveData<Bitmap>()
    }

    fun createBitmap(activity: Activity) {
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE) ?: return
        val name = sharedPref.getString(activity.getString(R.string.name_key), "")
        val github = sharedPref.getString(activity.getString(R.string.github_key), "")
        val twitter = sharedPref.getString(activity.getString(R.string.twitter_key), "")
        val qrData = "ca-tech://dojo/share?iam=$name&tw=$twitter&gh=$github"
        val barcodeEncoder = BarcodeEncoder()
        bitmap.value = barcodeEncoder.encodeBitmap(qrData, BarcodeFormat.QR_CODE, 500, 500)
    }

    fun saveDatabase(context: Context,result: IntentResult) {
        Log.d("readQR", result.contents)
        Toast.makeText(context, result.contents, Toast.LENGTH_LONG).show()
        //URL分割
        val uri = Uri.parse(result.contents)
        val name = uri.getQueryParameter("iam").toString()
        val github = uri.getQueryParameter("gh").toString()
        val twitter = uri.getQueryParameter("tw").toString()
        val user = User(
            name = name,
            github = github,
            twitter = twitter
        )
        Log.d("test", "${user.name}${user.github}${user.twitter}")
        //DBに保存
        val userDao = AppDatabase.getUserDatabase(context).userDao()
        viewModelScope.launch {
            userDao.insertUser(user)
        }
    }
}
