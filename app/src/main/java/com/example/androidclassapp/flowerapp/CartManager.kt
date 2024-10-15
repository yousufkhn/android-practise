package com.example.androidclassapp.flowerapp
import com.example.androidclassapp.model.Flower

object CartManager {
    private val cartItems = mutableListOf<Flower>()

    fun addToCart(flower: Flower) {
        if (!cartItems.contains(flower)) cartItems.add(flower)
        flower.quantityInCart++
    }

    fun removeFromCart(flower: Flower) {
        flower.quantityInCart--
        if (flower.quantityInCart <= 0) cartItems.remove(flower)
    }

    fun getCartItems(): List<Flower> = cartItems

    fun clearCart() {
        cartItems.clear()
    }

    fun getTotalPrice(): Int {
        return cartItems.sumOf { it.quantityInCart * it.price.toInt() }
    }
}