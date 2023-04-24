package com.example.homework6_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val activityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.edit.setText(result.data?.getStringExtra(KEY_FOR_TEXT))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListener()

    }

    private fun initListener() {
        binding.btn.setOnClickListener{
            if (binding.edit.text.isEmpty()){
                Toast.makeText(this, "Вы не ввели текст", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(KEY_FOR_TEXT,binding.edit.text.toString())
                activityLauncher.launch(intent)
            }
        }
    }

    companion object{
        const val KEY_FOR_TEXT = "text_key"
    }
}