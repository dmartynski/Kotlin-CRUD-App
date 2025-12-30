package org.setu.grocery.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
private var lastId = 0L

private fun getId(): Long {
    return lastId++
}

class GroceryMemStore : GroceryStore {

    val groceries = ArrayList<GroceryModel>()

    override fun findAll(): List<GroceryModel> {
        return groceries
    }

    override fun findOne(id: Long) : GroceryModel? {
        var foundGrocery: GroceryModel? = groceries.find { p -> p.id == id }
        return foundGrocery
    }

    override fun create(grocery: GroceryModel) {
        grocery.id = getId()
        groceries.add(grocery)
        logAll()
    }

    override fun update(grocery: GroceryModel) {
        var foundGrocery = findOne(grocery.id!!)
        if (foundGrocery != null) {
            foundGrocery.title = grocery.title
            foundGrocery.price = grocery.price
            foundGrocery.type = grocery.type
        }
    }


    override fun delete(grocery: GroceryModel) {
        groceries.remove(grocery)
    }

    internal fun logAll() {
        groceries.forEach { logger.info("${it}") }
    }
}