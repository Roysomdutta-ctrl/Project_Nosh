package com.example.recipecompose.views

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import com.example.recipecompose.service.Dish
import com.example.recipecompose.viewmodel.DishesViewModel
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun MainScreen() {
    val viewModel: DishesViewModel = viewModel()
    var selectedDish by remember { mutableStateOf<Dish?>(null) }
    var selectedCategory by remember { mutableStateOf("All") }

    Row {
        Sidebar(selectedCategory){ category -> selectedCategory = category }

        DishListScreen(viewModel) { dish ->
            selectedDish = dish // we update the selected dish on click
        }
    }

    //We will show the Dialog if a dish is selected
    selectedDish?.let { dish ->
        DishDetailDialog(dish, onDismiss = { selectedDish = null })
    }
}
