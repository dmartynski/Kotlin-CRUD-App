# Kotlin_Project

To use the app you have to run the Main.kt file found in the directory below
![obraz](https://github.com/20094523/Kotlin_Project/assets/74902424/7e77fd50-0772-428e-bc4a-3cf6ffadbd9e)

Here it is in intellij.


![obraz](https://github.com/20094523/Kotlin_Project/assets/74902424/5cab8374-eeba-4fc4-9b89-cd06e13c208e)
![obraz](https://github.com/20094523/Kotlin_Project/assets/74902424/cba49741-9233-4966-b393-25791a39c08e)

The app has JSON persistence, which you can toy around with by playing with the Grocery.json file that is created after you input an object.
The app contains Adding, Searching, Deleting, Updating and Listing of ''grocery'' objects, which contain the data of their name, id, price and type (1 for fruit 2 for vegetable).
The app has a standard loop until exit menu with colours that I added from code I found on stack overflow.
The app has data validation, adheres to kotlin best practices to the best of my knowledge, as I followed the labs as closely as possible, creating packages etc.
The app has a commit history and a branch which was the first few bits of code I wrote for this project.

If you were to expand on this app, you would add new options to the GroceryView file, for example, a filtering feature which loops through and lists only vegetables. To do that
you would add a line in the menu for it, call for a filter function, which would be taken from the GroceryController.kt file.
