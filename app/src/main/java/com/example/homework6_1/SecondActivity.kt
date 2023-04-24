package com.example.homework6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework6_1.databinding.ActivityMainBinding
import com.example.homework6_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListener()

    }

    private fun initListener() {
        binding.btn1.setOnClickListener {
            intent.putExtra(KEY_FOR_TEXT, binding.edit1.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        const val KEY_FOR_TEXT = "text_key"
    }
}