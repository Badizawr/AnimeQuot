package com.example.presentation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.presentation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = (application as ProvideViewModel).viewModel()

        viewModel.liveData.observe(this) {
            binding.mainTextView.text = it.second
            if (it.first)
                binding.mainTextView.setTextColor(Color.BLACK)
            else
                binding.mainTextView.setTextColor(Color.RED)
        }
        viewModel.load()
    }
}