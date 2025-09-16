package com.travelblog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.travelblog.adapter.MainAdapter
import com.travelblog.databinding.ActivityMainBinding
import com.travelblog.http.Blog
import com.travelblog.http.BlogHttpClient

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        binding.refreshLayout.setOnRefreshListener { // 1
            loadData()
        }

        loadData()
    }

    private fun loadData() {
        binding.refreshLayout.isRefreshing = true
        BlogHttpClient.loadBlogArticles(
            onSuccess = { blogList: List<Blog> ->
                binding.refreshLayout.isRefreshing = false
                runOnUiThread { adapter.submitList(blogList) }
            },
            onError = {
                binding.refreshLayout.isRefreshing = false
                runOnUiThread { showErrorSnackbar() }
            }
        )
    }

    private fun showErrorSnackbar() {
        Snackbar.make(binding.root,
            "Error during loading blog articles", Snackbar.LENGTH_INDEFINITE).run {
            setActionTextColor(resources.getColor(R.color.orange500))
            setAction("Retry") {
                loadData()
                dismiss()
            }
        }.show()
    }
}