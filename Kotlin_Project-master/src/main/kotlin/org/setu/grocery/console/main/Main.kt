package org.setu.grocery.console.main

import mu.KotlinLogging
import org.setu.grocery.console.controllers.GroceryController
import org.setu.grocery.console.models.GroceryJSONStore
import org.setu.grocery.console.models.GroceryModel
import org.setu.grocery.console.views.GroceryView

private val logger = KotlinLogging.logger {}

const val ANSI_RESET = "\u001B[0m"
const val ANSI_RED = "\u001B[31m"
const val ANSI_BLUE = "\u001B[34m"

val groceryView = GroceryView()
val groceries = GroceryJSONStore()
val controller = GroceryController()
fun main(args: Array<String>){
    GroceryController().start()
}

fun addGrocery(){
    var aGrocery = GroceryModel()

    if (groceryView.addGroceryData(aGrocery))
        groceries.create(aGrocery)
    else
        logger.info("Grocery not added.")
}

fun updateGrocery() {

    groceryView.listGroceries(groceries)
    var searchId = groceryView.getId()
    val aGrocery = search(searchId)

    if(aGrocery != null) {
        if(groceryView.updateGroceryData(aGrocery)) {
            groceries.update(aGrocery)
            groceryView.showGrocery(aGrocery)
            logger.info("Grocery Updated : [ $aGrocery ]")
        }
        else
            logger.info("Grocery Not Updated")
    }
    else
        println("Grocery Not Updated...")
}

fun searchGrocery() {
    val aGrocery = search(groceryView.getId())!!
    groceryView.showGrocery(aGrocery)
}


fun search(id: Long) : GroceryModel? {
    var foundGrocery = groceries.findOne(id)
    return foundGrocery
}