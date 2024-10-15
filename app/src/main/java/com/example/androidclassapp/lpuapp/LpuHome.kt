package com.example.androidclassapp.lpuapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidclassapp.R
import com.google.android.material.snackbar.Snackbar

class LpuHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lpu_home)

        val gridLayout = findViewById<GridLayout>(R.id.departmentsGrid)
        val inflater = LayoutInflater.from(this)

        DepartmentsData.departments.forEach{department: Department ->
            val cardView = inflater.inflate(R.layout.department_card,gridLayout,false) as CardView

            val imageButton = cardView.findViewById<ImageButton>(R.id.departmentImageButton)
            imageButton.setImageResource(department.imageResId)

            val textView = cardView.findViewById<TextView>(R.id.departmentTextView)
            textView.text = department.name

            cardView.setOnClickListener { view ->
                Snackbar.make(view,"Do u want to know more abt ${department.name} ? ",Snackbar.LENGTH_LONG).setAction("Yes"){
                    val intent = Intent(this,DepartmentDetails::class.java)
                    intent.putExtra("departmentName",department.name)
                    intent.putExtra("departmentDescription",department.description)
                    intent.putExtra("departmentImage",department.imageResId)
                    intent.putExtra("departmentFullName",department.fullName)
                    intent.putExtra("departmentImages",department.imagesResIds.toIntArray())
                    intent.putExtra("departmentLottie",department.departmentLottieResId)
                    startActivity(intent)
                }
                    .show()
            }

            gridLayout.addView(cardView)
        }

    }
}