package com.example.androidclassapp.lpuapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.androidclassapp.R
import org.w3c.dom.Text

class DepartmentDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_department_details)

        val departmentName = intent.getStringExtra("departmentName")
        val departmentDescription = intent.getStringExtra("departmentDescription")
        val departmentImage = intent.getIntExtra("departmentImage",0)
        val departmentFullName = intent.getStringExtra("departmentFullName")
        val departmentImages = intent.getIntArrayExtra("departmentImages")
        val departmentLottie = intent.getIntExtra("departmentLottie",0)


//        findViewById<ImageView>(R.id.departmentDetailsLogo).setImageResource(departmentImage)
        findViewById<TextView>(R.id.departmentDetailsTextView).text = departmentFullName


        val departmentImgLayout = findViewById<LinearLayout>(R.id.departmentImgLayout)

        if (departmentImages != null) {
            for (imageRedId in departmentImages){
                val cardView = LayoutInflater.from(this).inflate(R.layout.department_details_img_layout,departmentImgLayout,false) as androidx.cardview.widget.CardView

                val imageView = cardView.findViewById<ImageView>(R.id.departmentImg)
                imageView.setImageResource(imageRedId)
                departmentImgLayout.addView(cardView)
            }
        }

        findViewById<TextView>(R.id.departmentDescription).text = departmentDescription

        findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.departmentLottie).setAnimation(departmentLottie)


    }
}

