package com.thecode.onboardingviewagerexamples.activities

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.jaeger.library.StatusBarUtil
import com.thecode.onboardingviewagerexamples.R
import com.thecode.onboardingviewagerexamples.adapters.OnboardingViewPagerAdapter3
import kotlinx.android.synthetic.main.activity_onboarding_example3.*

class OnboardingExample3Activity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager
    private lateinit var textSkip: TextView
    private lateinit var textEnd: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_example3)
        mViewPager = viewPager
        mViewPager.adapter = OnboardingViewPagerAdapter3(supportFragmentManager, this)
        mViewPager.offscreenPageLimit = 1
        textSkip = text_skip
        textEnd = text_end
        StatusBarUtil.setTranslucentForImageViewInFragment(this, null)

        textSkip.setOnClickListener {
            finish()
        }

        textEnd.setOnClickListener {
            finish()
        }

        val btnNextStep: ImageButton = btn_next_step
        btnNextStep.setOnClickListener {
            if (getItem(+1) > mViewPager.childCount-1) {
              finish()
            } else {
                mViewPager.setCurrentItem(getItem(+1), true)
            }
        }


        /*if(getItem(+1) == mViewPager.childCount-1){
                btnNextStep.visibility = View.GONE
                textEnd.visibility = View.VISIBLE
            }else{
            btnNextStep.visibility = View.VISIBLE
            textEnd.visibility = View.GONE
        }*/
    }

    private fun getItem(i: Int): Int {
        return mViewPager.currentItem + i
    }
}
