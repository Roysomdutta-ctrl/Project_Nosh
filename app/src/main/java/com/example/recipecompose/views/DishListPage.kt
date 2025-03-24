package com.example.recipecompose.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipecompose.service.Dish
import com.example.recipecompose.ui.theme.BluePrimary
import com.example.recipecompose.viewmodel.DishesViewModel

@Composable
fun  DishListScreen(viewModel: DishesViewModel, onDishSelected: (Dish) -> Unit) {
/*    var searchQuery by remember { mutableStateOf("") }

    Column {
        SearchBar(searchQuery) { searchQuery = it }

        LazyRow{
            items(viewModel.listOfDishes.filter { it.dishName.contains(searchQuery, ignoreCase = true) }) { dish ->
                DishCard(dish) { onDishSelected(dish) }
            }
        }
    }*/

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {


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
            items(viewModel.listOfDishes.filter { it.dishName.contains(searchQuery, ignoreCase = true) }) { dish ->
                DishCard(dish) { onDishSelected(dish) } // Pass clicked dish
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Suggestions()
    }
}

/*@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        placeholder = { Text("Search dishes...") }
    )
}*/









