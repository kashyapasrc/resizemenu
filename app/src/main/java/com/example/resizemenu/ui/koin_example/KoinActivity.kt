package com.example.resizemenu.ui.koin_example

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resizemenu.R
import com.example.resizemenu.domain.models.User
import com.example.resizemenu.ui.user_info.UserInfoAdapter
import com.example.resizemenu.utils.Status
import kotlinx.android.synthetic.main.activity_koin.*
import org.koin.android.viewmodel.ext.android.viewModel

class KoinActivity : AppCompatActivity() {

    private val koinViewModel : KoinViewModel by viewModel()

    private lateinit var adapter: UserInfoAdapter
    //val koinViewModel: KoinViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koin)
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = UserInfoAdapter()
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(DividerItemDecoration(this,RecyclerView.VERTICAL))
        setupObserver()


    }

    private fun setupObserver() {
        koinViewModel.users.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    //it.data?.let { users -> renderList(users) }
                    it.data?.let { users -> renderList(users) }
                    recycler_view.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    //recycler_view.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.setNewList(users)
        adapter.notifyDataSetChanged()
    }

    fun hitApi(view: View) {

        setupObserver()
    }
}