package com.nkjp.a19dojo_kotlin.ui.list

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nkjp.a19dojo_kotlin.R
import com.nkjp.a19dojo_kotlin.ui.qr.AppDatabase
import kotlinx.android.synthetic.main.fragment_list.*
import kotlin.concurrent.thread

class ListFragment : Fragment() {

    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO リサイクラビュー
        val handler = Handler()
        Thread(Runnable {
            val db = AppDatabase.getUserDatabase(requireContext())
            val users = db.userDao().getAllUsers()
            val adp = UserAdapter(users)
            handler.post(Runnable {
                recycleView.layoutManager = LinearLayoutManager(context)
                recycleView.setHasFixedSize(true)
                recycleView.adapter = adp
                Log.d("TEST",users.toString())
            })
        }).start()
    }
}