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
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.room.Room
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.nkjp.a19dojo_kotlin.R
import kotlinx.android.synthetic.main.fragment_qr.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class QrFragment : Fragment() {

    private val viewModel: QrViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_qr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.createBitmap(requireActivity())
        viewModel.bitmap.observe(viewLifecycleOwner, Observer {
            try {
                qrImage.setImageBitmap(it)
            } catch (e: WriterException) {
                throw AndroidRuntimeException("Barcode Error.", e)
            }
        })
        //カメラ起動
        qrReadButton.setOnClickListener {
            val integrator = IntentIntegrator.forSupportFragment(this)
            integrator.initiateScan()
        }
    }

    //QR読み取り
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            viewModel.saveDatabase(requireContext(), result)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}