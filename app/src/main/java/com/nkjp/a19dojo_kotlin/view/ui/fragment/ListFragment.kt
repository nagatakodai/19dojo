package com.nkjp.a19dojo_kotlin.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nkjp.a19dojo_kotlin.R
import com.nkjp.a19dojo_kotlin.view.adapter.UserAdapter
import com.nkjp.a19dojo_kotlin.viewModel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

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
            recycleView.adapter =
                UserAdapter(
                    it,
                    requireContext()
                )
        })
    }
}