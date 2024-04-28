package com.dicoding.asclepius.view

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Menampilkan hasil gambar, prediksi, dan confidence score.
        val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        val result = intent.getStringExtra(EXTRA_RESULT)

        imageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.resultImage.setImageURI(it)
        }
        result?.let {
            // Untuk menampilkan hasil prediksi atau skor ke dalam TextView
            binding.resultText.text = it
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_RESULT = "extra_result"
    }

}