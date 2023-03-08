package com.example.worldfactory.ui.intro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.worldfactory.R
import com.example.worldfactory.ui.login.LoginActivity
import com.example.worldfactory.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    private lateinit var viewPager: ViewPager2

    private var currentPageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewpagerintro
        viewPager.adapter = StateAdapter(this)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position < 2)
                    binding.buttonNext.text = getString(R.string.next)
                else
                    binding.buttonNext.text = getString(R.string.start)
                currentPageIndex = position
            }
        })

        binding.buttonNext.setOnClickListener {
            // TODO: make a finite state machine ?
            // Ten reasons to leave like that :^)
            if(currentPageIndex < 2){
                currentPageIndex++

                viewPager.setCurrentItem(currentPageIndex, true)
                if(currentPageIndex == 2)
                    binding.buttonNext.text = getString(R.string.start)

                return@setOnClickListener
            }

            val intent = Intent(this@IntroActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.buttonSkip.setOnClickListener {
            val intent = Intent(this@IntroActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if(currentPageIndex > 0){
            currentPageIndex--
            viewPager.setCurrentItem(currentPageIndex, true)
            if(currentPageIndex < 2) binding.buttonNext.text = getString(R.string.next)
        } else {
            super.onBackPressed()
        }
    }
}