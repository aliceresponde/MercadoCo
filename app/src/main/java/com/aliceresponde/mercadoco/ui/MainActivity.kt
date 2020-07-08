package com.aliceresponde.mercadoco.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aliceresponde.mercadoco.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}