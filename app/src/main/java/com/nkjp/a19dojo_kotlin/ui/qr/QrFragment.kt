package com.nkjp.a19dojo_kotlin.ui.qr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nkjp.a19dojo_kotlin.R

class QrFragment : Fragment() {

    private lateinit var qrViewModel: QrViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        qrViewModel =
                ViewModelProviders.of(this).get(QrViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_qr, container, false)

        qrViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }
}