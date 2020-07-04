package com.nkjp.a19dojo_kotlin.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nkjp.a19dojo_kotlin.R
import com.nkjp.a19dojo_kotlin.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

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