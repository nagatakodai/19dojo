package com.nkjp.a19dojo_kotlin.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nkjp.a19dojo_kotlin.model.AppDatabase
import com.nkjp.a19dojo_kotlin.model.User
import com.nkjp.a19dojo_kotlin.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel : ViewModel() {

    val users = MutableLiveData<List<User>>().apply {
        MutableLiveData<List<User>>()
    }

    fun createAdapter(context: Context) {
        val db = AppDatabase.getUserDatabase(context).userDao()
        val repository = UserRepository(db)
        viewModelScope.launch(Dispatchers.IO) {
            val temp = repository.getUser()
            withContext(Dispatchers.Main) {
                users.value = temp
            }
        }
    }
}