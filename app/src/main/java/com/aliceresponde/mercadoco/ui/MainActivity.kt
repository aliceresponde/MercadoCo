package com.aliceresponde.mercadoco.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aliceresponde.mercadoco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}