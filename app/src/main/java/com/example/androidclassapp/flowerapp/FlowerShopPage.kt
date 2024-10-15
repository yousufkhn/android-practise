package com.example.androidclassapp.flowerapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidclassapp.R
import com.example.androidclassapp.model.Flower
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar

class FlowerShopPage : AppCompatActivity() {

    private lateinit var flowers: List<Flower>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flowershop_homepage)


        // dynamic welcome message according to time of the day
        val welcomeMessage = findViewById<TextView>(R.id.welcomeMessage)

        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        val greetingMessage = when (hourOfDay) {
            in 0..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            else -> "Good Evening"
        }

        welcomeMessage.text = "$greetingMessage, Yousuf"



        flowers = listOf(
            Flower("Sunflower", 50, R.drawable.sunflower),
            Flower("Rose", 30, R.drawable.rose),
            Flower("Lily", 60, R.drawable.lily),
            Flower("Daisy", 40, R.drawable.daisy),
            Flower("Orchid", 120, R.drawable.orchid),
            Flower("Tulip", 80, R.drawable.tulip),
            Flower("Carnation", 45, R.drawable.carnation),
            Flower("Jasmine", 20, R.drawable.jasmine)

        )

        val searchBar = findViewById<EditText>(R.id.flower_search_bar)

        displayFlowers(flowers)

        searchBar.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                val query = s.toString()
                if (query.isEmpty()) {
                    displayFlowers(flowers)
                } else {
                    val filteredFlowers = flowers.filter {
                        it.name.contains(query, ignoreCase = true)
                    }
                    displayFlowers(filteredFlowers)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        val CartButton = findViewById<FloatingActionButton>(R.id.cart_button)

        CartButton.setOnClickListener {
            val intent = Intent(this, FlowerCartPage::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        // Refresh flower list when returning to this activity (reload cart quantities)
        displayFlowers(flowers)
    }

    fun displayFlowers(flowers: List<Flower>) {
        val scrollViewLayout = findViewById<LinearLayout>(R.id.flower_scrollView_id)
        scrollViewLayout.removeAllViews()

        for (flower in flowers) {
            val cardView = layoutInflater.inflate(R.layout.flower_card, null)
            val flowerImage = cardView.findViewById<ImageView>(R.id.flower_image)
            val flowerName = cardView.findViewById<TextView>(R.id.flower_name)
            val flowerPrice = cardView.findViewById<TextView>(R.id.flower_price)
            val flowerQuantity = cardView.findViewById<TextView>(R.id.flower_quantity)
            val increaseQuantityButton = cardView.findViewById<Button>(R.id.add_button)
            val decreaseQuantityButton = cardView.findViewById<Button>(R.id.minus_button)

            flowerImage.setImageResource(flower.imageResId)
            flowerName.text = flower.name
            flowerPrice.text = "₹${flower.price}"
            flowerQuantity.text = flower.quantityInCart.toString()

            increaseQuantityButton.setOnClickListener {
                CartManager.addToCart(flower)
                flowerQuantity.text = flower.quantityInCart.toString()
            }

            decreaseQuantityButton.setOnClickListener {
                if (flower.quantityInCart > 0){
                    CartManager.removeFromCart(flower)
                    flowerQuantity.text = flower.quantityInCart.toString()
                }

            }

            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(20, 20, 20, 20)
            cardView.layoutParams = layoutParams

            scrollViewLayout.addView(cardView)

        }

    }


}


