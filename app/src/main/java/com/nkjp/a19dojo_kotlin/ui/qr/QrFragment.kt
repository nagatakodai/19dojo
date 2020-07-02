package com.nkjp.a19dojo_kotlin.ui.qr

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.util.AndroidRuntimeException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.nkjp.a19dojo_kotlin.R
import com.nkjp.a19dojo_kotlin.ui.home.HomeFragment
import kotlinx.android.synthetic.main.fragment_qr.*

class QrFragment : Fragment() {

    private lateinit var qrViewModel: QrViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_qr, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE) ?:return
        val name = sharedPref.getString(getString(R.string.name_key), "")
        val github = sharedPref.getString(getString(R.string.github_key), "")
        val twitter = sharedPref.getString(getString(R.string.twitter_key), "")
        val qrData = "ca-tech://dojo/share?iam=$name&tw=$twitter&gh=$github"
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap(qrData, BarcodeFormat.QR_CODE, 500, 500)
            qrImage.setImageBitmap(bitmap)
            qrText.text = "あなたのURLは、$qrData です。"
        }catch (e: WriterException){
            throw AndroidRuntimeException("Barcode Error.",e)
        }
    }
}