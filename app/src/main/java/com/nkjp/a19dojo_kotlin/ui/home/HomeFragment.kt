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
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.nkjp.a19dojo_kotlin.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE) ?: return
        val name = sharedPref.getString(getString(R.string.name_key), "")
        val github = sharedPref.getString(getString(R.string.github_key), "")
        val twitter = sharedPref.getString(getString(R.string.twitter_key), "")

        edit_name.setText(name)
        edit_github.setText(github)
        edit_twitter.setText(twitter)

        saveButton.setOnClickListener {
            this.onSave(
                requireActivity(),
                edit_name.text,
                edit_github.text,
                edit_twitter.text
            )
        }
    }
    private fun onSave(activity : Activity, edit_name : Editable?, edit_github : Editable?, edit_twitter : Editable?){
        val name = edit_name.toString()
        val github = edit_github.toString()
        val twitter = edit_twitter.toString()
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
        sharedPref.edit {
            putString(activity.getString(R.string.name_key),name)
            putString(activity.getString(R.string.github_key),github)
            putString(activity.getString(R.string.twitter_key),twitter)
        }
        val qrData = "ca-tech://dojo/share?iam=$name&tw=$twitter&gh=$github"
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap(qrData, BarcodeFormat.QR_CODE, 500, 500)
        }catch (e: WriterException){
            throw AndroidRuntimeException("Barcode Error.",e)
        }
    }
}