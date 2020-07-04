package com.nkjp.a19dojo_kotlin.ui.home

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.util.AndroidRuntimeException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.nkjp.a19dojo_kotlin.R
import com.nkjp.a19dojo_kotlin.ui.qr.QrFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_qr.*

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getMyData(requireActivity())

        viewModel.name.observe(viewLifecycleOwner, Observer {
            edit_name.setText(it)
        })
        viewModel.github.observe(viewLifecycleOwner, Observer {
            edit_github.setText(it)
        })
        viewModel.twitter.observe(viewLifecycleOwner, Observer{
            edit_twitter.setText(it)
        })

        saveButton.setOnClickListener {
            viewModel.onSave(
                requireActivity(),
                edit_name.text,
                edit_github.text,
                edit_twitter.text
            )
        }
    }

}