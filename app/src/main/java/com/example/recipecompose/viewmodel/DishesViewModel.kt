package com.example.recipecompose.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.recipecompose.service.Dish
import com.example.recipecompose.service.RetrofitInstance

/**
 * This is the viewmodel class that will work as a
 * communicator between the model and the view and
 * will manage the data coming from the Api call.
 */
class DishesViewModel : ViewModel() {
    var listOfDishes by mutableStateOf<List<Dish>>(emptyList())
    init {
        fetchDishes()
    }

    private fun fetchDishes() {
        //using coroutines below
        viewModelScope.launch {
            try {
                listOfDishes = RetrofitInstance.api.getDishes()
                Log.d("API_RESPONSE", "Received ${listOfDishes.size} dishes")
                listOfDishes.forEach { dish ->
                    Log.d("API_RESPONSE", "Dish Name: ${dish.dishName}, Image URL: ${dish.imageUrl}")
                }
                //Log.d("RetrofitResponse", "Data received: ${listOfDishes}")
                //Toast.makeText(context, "Data: ${listOfDishes}", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Log.e("API_ERROR", "Failed to fetch dishes: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}
