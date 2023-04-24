package com.example.homework6_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework6_1.MainActivity.Companion.KEY_FOR_TEXT
import com.example.homework6_1.databinding.ActivityMainBinding
import com.example.homework6_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.edit1.setText(intent.getStringExtra(KEY_FOR_TEXT))
        initListener()

    }

    private fun initListener() {
        binding.btn1.setOnClickListener {
            intent.putExtra(KEY_FOR_TEXT, binding.edit1.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}