package com.example.project1_group9

import java.io.Serializable

data class Product(
    var name: String = "",
    var manufacturer: String = "",
    var url: String = "",
    var description: String = "",
    var fullDescription: String = "",
    var price: Double = 0.0
): Serializable {
}
