package com.example.viewmodelarchcomp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LiveData : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    private val factsTextVeiw: TextView
    get( ) = findViewById(R.id.txt)

    private val btnUpdate: Button
    get( ) = findViewById(R.id.btn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)

        mainViewModel.factsLiveData.observe(this, Observer{
            // Executes if live data changes
            factsTextVeiw.text = it

        })

        btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }
    }
}