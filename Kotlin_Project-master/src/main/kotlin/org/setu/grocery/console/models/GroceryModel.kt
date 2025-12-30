package org.setu.grocery.console.models

data class GroceryModel(
    var id: Long = 0,
    var title: String = "",
    var price: Double = .0,
    var type: Int = 0,
    )