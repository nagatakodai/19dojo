package com.nkjp.a19dojo_kotlin.ui.home

import android.app.Activity
import android.content.Context
import android.text.Editable
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nkjp.a19dojo_kotlin.R

class HomeViewModel : ViewModel() {
    //TODO state
    val name : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val github : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val twitter : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun onSave(
        activity: Activity,
        edit_name: Editable?,
        edit_github: Editable?,
        edit_twitter: Editable?
    ) {
        val name = edit_name.toString()
        val github = edit_github.toString()
        val twitter = edit_twitter.toString()
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
        sharedPref.edit {
            putString(activity.getString(R.string.name_key), name)
            putString(activity.getString(R.string.github_key), github)
            putString(activity.getString(R.string.twitter_key), twitter)
        }
    }
    fun getMyData(
        activity: Activity
    ){
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
        name.value = sharedPref.getString(activity.getString(R.string.name_key),"")
        github.value = sharedPref.getString(activity.getString(R.string.github_key),"")
        twitter.value = sharedPref.getString(activity.getString(R.string.twitter_key), "")

    }
}