package com.example.recipecompose.viewmodel


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipecompose.views.DishCard
import com.example.recipecompose.views.SearchBar
import com.example.recipecompose.views.IndianFoodRow
import com.example.recipecompose.views.Suggestions
import com.example.recipecompose.service.Dish
import com.example.recipecompose.ui.theme.BluePrimary

@Composable
fun DishListScreen(
    dishes: List<Dish>,  // Receives a list of dishes
    searchQuery: String,
    onDishSelected: (Dish) -> Unit
) {

    Column(modifier = Modifier.fillMaxSize().padding(16.dp, )) {

        var searchQuery by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(16.dp))

        SearchBar(searchQuery) { searchQuery = it }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "What's on your mind?",
            style = TextStyle(fontSize = 18.sp, color = BluePrimary,fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = 16.dp)
            //modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(12.dp))

        IndianFoodRow()

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Recommendations",
            style = TextStyle(fontSize = 18.sp, color = BluePrimary,fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = 16.dp)
            //modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        LazyRow {
            items(dishes.filter { it.dishName.contains(searchQuery, ignoreCase = true) }) { dish ->
                DishCard(dish) { onDishSelected(dish) }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Suggestions()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDishListScreen() {
    val sampleDishes = listOf(
        Dish(dishName = "Margherita Pizza", imageUrl = " "),
        Dish(dishName = "BBQ Chicken Pizza", imageUrl = " "),
        Dish(dishName = "Cheese Burger", imageUrl = " ")
    )

    DishListScreen(
        dishes = sampleDishes,
        searchQuery = "",
        onDishSelected = {}
    )
}
