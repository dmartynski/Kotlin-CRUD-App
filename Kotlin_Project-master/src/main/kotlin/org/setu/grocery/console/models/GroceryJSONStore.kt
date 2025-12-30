package org.setu.grocery.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.setu.grocery.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "groceries.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<GroceryModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class GroceryJSONStore: GroceryStore {

    var groceries = mutableListOf<GroceryModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<GroceryModel> {
        return groceries
    }

    override fun findOne(id: Long) : GroceryModel? {
        var foundGrocery: GroceryModel? = groceries.find { p -> p.id == id }
        return foundGrocery
    }

    override fun create(grocery: GroceryModel) {
        grocery.id = generateRandomId()
        groceries.add(grocery)
        serialize()
    }

    override fun update(grocery: GroceryModel) {
        var foundGrocery = findOne(grocery.id!!)
        if (foundGrocery != null) {
            foundGrocery.title = grocery.title
            foundGrocery.price = grocery.price
            foundGrocery.type = grocery.type
        }
        serialize()
    }
    override fun delete(grocery: GroceryModel) {
        groceries.remove(grocery)
        serialize()
    }

    internal fun logAll() {
        groceries.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(groceries, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        groceries = Gson().fromJson(jsonString, listType)
    }
}