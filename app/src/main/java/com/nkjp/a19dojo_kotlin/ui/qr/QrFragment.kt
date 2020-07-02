package com.nkjp.a19dojo_kotlin.ui.qr

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.AndroidRuntimeException
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.nkjp.a19dojo_kotlin.R
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
        //Toast.makeText(activity,"読み込みました",Toast.LENGTH_SHORT).show()
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap(qrData, BarcodeFormat.QR_CODE, 500, 500)
            qrImage.setImageBitmap(bitmap)
            qrText.text = "あなたのURLは、$qrData です。"
        }catch (e: WriterException){
            throw AndroidRuntimeException("Barcode Error.",e)
        }
        //カメラ起動
        qrReadButton.setOnClickListener{
            val integrator = IntentIntegrator.forSupportFragment(this)
            integrator.initiateScan()
        }
    }
    //QR読み取り
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            Log.d("readQR", result.contents)
            Toast.makeText(context, result.contents,Toast.LENGTH_LONG).show()
            //TODO URL分割
            val uri = Uri.parse(result.contents)
            val name = uri.getQueryParameter("iam").toString()
            val github = uri.getQueryParameter("gh").toString()
            val twitter = uri.getQueryParameter("tw").toString()
            val user = User(
            name = name,
            github = github,
            twitter = twitter
            )
            Log.d("test","${user.name}${user.github}${user.twitter}")
            //TODO DBに保存

        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}