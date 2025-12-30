package org.setu.grocery.console.models

interface GroceryStore {
    fun findAll(): List<GroceryModel>
    fun findOne(id: Long): GroceryModel?
    fun create(grocery: GroceryModel)
    fun update(grocery: GroceryModel)

    fun delete(grocery: GroceryModel)
}