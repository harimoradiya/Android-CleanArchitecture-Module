package com.example.commontemplate

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.commontemplate.databinding.ActivityMainBinding
import com.example.commontemplate.presentation.viewmodel.MyViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val myViewModel : MyViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val progressBar = binding.pbImageLoader


        lifecycleScope.launch {
            myViewModel.saveImages.collect{ images ->
                if (images.isNotEmpty()){
                    val latestImage = images.last().imageUrl

                    Glide.with(this@MainActivity)
                        .load(latestImage)
                        .into(binding.ivImage)
                }

            }
        }



        myViewModel.isLoading.observe(this){
            progressBar.visibility = if (it) View.VISIBLE else View.GONE

        }

        binding.btnFetch.setOnClickListener {
            myViewModel.fetchAndSaveImages()
        }


    }
}