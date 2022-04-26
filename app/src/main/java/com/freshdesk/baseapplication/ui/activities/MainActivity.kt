package com.freshdesk.baseapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.freshdesk.baseapplication.R
import com.freshdesk.baseapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}