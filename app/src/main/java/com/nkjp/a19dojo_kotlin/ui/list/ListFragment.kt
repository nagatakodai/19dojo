package com.nkjp.a19dojo_kotlin.ui.list

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nkjp.a19dojo_kotlin.R
import com.nkjp.a19dojo_kotlin.ui.qr.AppDatabase
import kotlinx.android.synthetic.main.fragment_list.*
import kotlin.concurrent.thread

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.createAdapter(requireContext())
        viewModel.users.observe(viewLifecycleOwner, Observer {
            recycleView.layoutManager = LinearLayoutManager(context)
            recycleView.setHasFixedSize(false)
            recycleView.adapter = UserAdapter(it,requireContext())
        })
    }
}