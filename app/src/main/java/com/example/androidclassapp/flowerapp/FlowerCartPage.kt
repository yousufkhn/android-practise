package com.example.androidclassapp.flowerapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.text.SpannableString
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.airbnb.lottie.LottieAnimationView
import com.example.androidclassapp.R
import com.example.androidclassapp.model.Flower

class FlowerCartPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flower_cart_page)
        displayCartFlowers(CartManager.getCartItems())
        updateTotalPrice()

        val scrollView = findViewById<ScrollView>(R.id.cart_scroll_view)

        scrollView.viewTreeObserver.addOnGlobalLayoutListener {
            val r = Rect()
            scrollView.getWindowVisibleDisplayFrame(r)
            val screenHeight = scrollView.rootView.height

            val keypadHeight = screenHeight - r.bottom

            if (keypadHeight > screenHeight * 0.15) {
                scrollView.post {
                    scrollView.fullScroll(View.FOCUS_DOWN)
                }
            }
        }

        val placeOrderButton = findViewById<Button>(R.id.place_order_button)

        placeOrderButton.setOnClickListener {
            val intent = Intent(this, OrderSuccessPage::class.java)
            startActivity(intent)
        }


    }


    private fun displayCartFlowers(cartFlowers: List<Flower>) {
        val cartLayout = findViewById<LinearLayout>(R.id.cart_items_layout)


//        cartLayout.removeAllViews()

        for (flower in cartFlowers) {
            val cardView = layoutInflater.inflate(R.layout.flower_card, null)
            val flowerImage = cardView.findViewById<ImageView>(R.id.flower_image)
            val flowerName = cardView.findViewById<TextView>(R.id.flower_name)
            val flowerPrice = cardView.findViewById<TextView>(R.id.flower_price)
            val flowerQuantity = cardView.findViewById<TextView>(R.id.flower_quantity)
            val increaseQuantityButton = cardView.findViewById<Button>(R.id.add_button)
            val decreaseQuantityButton = cardView.findViewById<Button>(R.id.minus_button)

            // Set the flower data
            flowerImage.setImageResource(flower.imageResId)
            flowerName.text = flower.name
            flowerPrice.text = "₹${flower.price}"
            flowerQuantity.text = flower.quantityInCart.toString()

            increaseQuantityButton.setOnClickListener {
                CartManager.addToCart(flower)
                flowerQuantity.text = flower.quantityInCart.toString()
                updateTotalPrice()

            }

            decreaseQuantityButton.setOnClickListener {
                if (flower.quantityInCart > 0) {
                    CartManager.removeFromCart(flower)
                    flowerQuantity.text = flower.quantityInCart.toString()
                    updateTotalPrice()
                    if (flower.quantityInCart == 0) {
                        cartLayout.removeView(cardView)
                    }
                }

            }


            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 20, 0, 20)
            cardView.layoutParams = layoutParams

            cartLayout.addView(cardView)
        }
    }

    private fun updateTotalPrice() {
        val totalPriceTextView = findViewById<TextView>(R.id.total_price)
        val breakDownLayout = findViewById<LinearLayout>(R.id.items_breakdown_layout)
        val cartPageTotal = findViewById<TextView>(R.id.cart_page_total)
        val couponLayout = findViewById<LinearLayout>(R.id.coupon_layout)
        val priceDetailsLayout = findViewById<LinearLayout>(R.id.price_details_layout)
        val emptyCartAnimation = findViewById<LottieAnimationView>(R.id.lottie_empty_cart)
        val emptyCartText = findViewById<TextView>(R.id.empty_cart_text)
        val madeWithTextView = findViewById<TextView>(R.id.made_with_love_text)
        val orderButtonLayout = findViewById<ConstraintLayout>(R.id.order_button_layout)
        val cartLayout = findViewById<LinearLayout>(R.id.cart_items_layout)

        val cartFlowers = CartManager.getCartItems()
        var totalPrice = 0


        for (flower in cartFlowers) {
            totalPrice += flower.price * flower.quantityInCart
        }


        if (cartFlowers.isEmpty()) {
            // Show the Lottie animation and hide price and coupon sections
            emptyCartAnimation.visibility = View.VISIBLE
            couponLayout.visibility = View.GONE
            priceDetailsLayout.visibility = View.GONE
            emptyCartText.visibility = View.VISIBLE
            madeWithTextView.visibility = View.GONE
            orderButtonLayout.visibility = View.GONE
            cartLayout.visibility = View.GONE
        } else {
            // Hide the Lottie animation and show price and coupon sections
            emptyCartAnimation.visibility = View.GONE
            couponLayout.visibility = View.VISIBLE
            priceDetailsLayout.visibility = View.VISIBLE
            emptyCartText.visibility = View.GONE
            madeWithTextView.visibility = View.VISIBLE
            orderButtonLayout.visibility = View.VISIBLE
            cartLayout.visibility = View.VISIBLE

            totalPriceTextView.text = "Total Amount: ₹$totalPrice"
            cartPageTotal.text = "Total : ₹$totalPrice"

            // Update the breakdown layout
            breakDownLayout.removeAllViews()
            for (flower in cartFlowers) {
                val breakdownItemLayout = LinearLayout(this).apply {
                    orientation = LinearLayout.HORIZONTAL
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    setPadding(0, 8, 0, 0)
                }

                val flowerNameTextView = TextView(this).apply {
                    text = flower.name
                    textSize = 16f
                    setTextColor(Color.parseColor("#000000"))
                    layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                }

                val priceBreakdownTextView = TextView(this).apply {
                    text = "${flower.quantityInCart} x ₹${flower.price}"
                    textSize = 16f
                    setTextColor(Color.parseColor("#000000"))
                    gravity = Gravity.END
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                }

                // Add both TextViews to the horizontal LinearLayout
                breakdownItemLayout.addView(flowerNameTextView)
                breakdownItemLayout.addView(priceBreakdownTextView)

                // Add the horizontal LinearLayout to the parent layout
                breakDownLayout.addView(breakdownItemLayout)
            }
        }
    }
}