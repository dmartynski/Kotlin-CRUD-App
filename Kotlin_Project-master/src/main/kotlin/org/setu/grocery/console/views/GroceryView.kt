package org.setu.grocery.console.views

import org.setu.grocery.console.controllers.ANSI_RED
import org.setu.grocery.console.controllers.ANSI_RESET
import org.setu.grocery.console.main.ANSI_BLUE
import org.setu.grocery.console.models.GroceryJSONStore
import org.setu.grocery.console.models.GroceryModel
class GroceryView {
    fun menu() : Int {

        var option : Int
        var input: String?

        println(ANSI_BLUE+"MAIN MENU"+ ANSI_RESET)
        println(org.setu.grocery.console.controllers.ANSI_BLUE+" 1. Add Grocery"+ ANSI_RESET)
        println(ANSI_BLUE+" 2. Update Grocery"+ ANSI_RESET)
        println(ANSI_BLUE+" 3. List All Groceries"+ ANSI_RESET)
        println(org.setu.grocery.console.controllers.ANSI_BLUE+" 4. Search Grocery"+ org.setu.grocery.console.main.ANSI_RESET)
        println(org.setu.grocery.console.controllers.ANSI_BLUE+" 5. Delete Grocery"+ ANSI_RESET)
        println(org.setu.grocery.console.controllers.ANSI_BLUE+"-1. Exit"+ ANSI_RESET)
        println()
        print("Enter Option : ")
        input = readln()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listGroceries(groceries: GroceryJSONStore) {
        println("List All Groceries")
        println()
        groceries.logAll()
        println()
    }

    fun showGrocery(grocery : GroceryModel) {
        if(grocery != null)
            println("Grocery Details [ $grocery ]")
        else
            println(ANSI_RED+"Grocery Not Found..."+ ANSI_RESET)
    }

    fun addGroceryData(grocery : GroceryModel) : Boolean {

        println()
        print("Enter a Title : ")
        grocery.title = readln()!!
        print("Enter a price : ")
        grocery.price = readlnOrNull()?.toDoubleOrNull()!!
        print("Enter the type : 1) fruit 2) veg")
        println()
        grocery.type = readLine()?.toIntOrNull()!!
        return grocery.title.isNotEmpty() && !grocery.price.isNaN()
    }

    fun updateGroceryData(grocery: GroceryModel ) : Boolean {

        var tempTitle: String?
        var tempPrice: Double?
        var tempType: Int?

        if (grocery != null) {
            print("Enter a new Title for [ " + grocery.title + " ] : ")
            tempTitle = readln()!!
            print("Enter a new price for [ " + grocery.title + " ] : ")
            tempPrice = readLine()?.toDoubleOrNull()!!
            print("Enter the new type of [ " + grocery.title + " ] : ")
            tempType = readLine()?.toIntOrNull()!!

            if (!tempTitle.isNullOrEmpty() && !tempPrice.isNaN() ) {
                grocery.title = tempTitle
                grocery.price = tempPrice
                grocery.type = tempType
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readln()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}