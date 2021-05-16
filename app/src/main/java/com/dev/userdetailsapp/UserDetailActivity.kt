package com.dev.userdetailsapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.userdetailsapp.data.ApiHelperImpl
import com.dev.userdetailsapp.data.RetrofitBuilder
import com.dev.userdetailsapp.model.Users
import com.dev.userdetailsapp.util.Status
import com.dev.userdetailsapp.viewmodel.UserDetailViewModel
import kotlinx.android.synthetic.main.user_detail.*


class UserDetailActivity : AppCompatActivity() {
    private lateinit var userDetailViewModel: UserDetailViewModel
    private lateinit var adapter: UserDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_detail)
        setupUserDetailsUI()
        setupViewModel()
        setupObserver()
    }


    private fun setupUserDetailsUI() {
        userList.layoutManager = LinearLayoutManager(this)
        adapter = UserDetailsAdapter(arrayListOf())
        userList.adapter = adapter
    }


    private fun setupObserver() {
        userDetailViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { newsList -> renderList(newsList) }
                    userList.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    userList.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setupViewModel() {
        userDetailViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService))
        ).get(UserDetailViewModel::class.java)
    }

    private fun renderList(newsList: List<Users>) {
        adapter.addUserDetailsData(newsList)
    }


}