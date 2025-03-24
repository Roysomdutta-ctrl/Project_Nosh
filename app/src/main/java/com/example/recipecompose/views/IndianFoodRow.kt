package com.example.recipecompose.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipecompose.R
import com.example.recipecompose.models.FoodCategory

@Composable
fun IndianFoodRow() {
    val indianFoods = listOf(
        FoodCategory("Rice Items", R.drawable.jeera_rice),  // Replace with actual drawable images
        FoodCategory("Indian", R.drawable.indian_food),
        FoodCategory("Curries", R.drawable.curries),
        FoodCategory("Soups", R.drawable.soups),
        FoodCategory("Deserts", R.drawable.desserts),
        FoodCategory("Snacks", R.drawable.snacks)
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(indianFoods) { food ->
            FoodCategoryCardView(food)
        }
    }
}