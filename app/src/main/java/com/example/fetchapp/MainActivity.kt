package com.example.fetchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import com.example.fetchapp.databinding.ActivityMainBinding
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isResultsShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showButton()
    }

    private fun showButton() {
        binding.btnToggle.setOnClickListener {
            if (isResultsShown) {
                binding.recyclerView.visibility = View.GONE
                binding.btnToggle.text = "Show Results"
            } else {
                fetchData()
                binding.recyclerView.visibility = View.VISIBLE
                binding.btnToggle.text = "Close"
            }
            isResultsShown = !isResultsShown
        }
    }

    private fun fetchData() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val items = RetrofitClient.apiService.fetchItems()
            val filteredItems = items.filter { it.name != null && it.name.isNotBlank() }
                .sortedWith(compareBy<Item> { it.listId }.thenBy { it.name })
                .groupBy { it.listId }

            Log.d("MainActivity", "Fetched and filtered items: $filteredItems")

            withContext(Dispatchers.Main) {
                updateUI(filteredItems)
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Error fetching data", e)
        }
    }

    private fun updateUI(items: Map<Int, List<Item>>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(items)

        // Create and add the divider decoration to the RecyclerView
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

}