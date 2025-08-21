package me.hd.ggtutorial.ui.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import me.hd.ggtutorial.BuildConfig
import me.hd.ggtutorial.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "${BuildConfig.TAG} ${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})"
    }
}