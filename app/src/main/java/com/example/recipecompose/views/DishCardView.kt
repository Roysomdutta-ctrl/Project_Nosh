package com.example.recipecompose.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.recipecompose.R
import com.example.recipecompose.service.Dish
import com.example.recipecompose.ui.theme.BluePrimary

@Composable
fun DishCard(dish: Dish, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .padding(8.dp)
            .clickable { onClick() },// this shall open dialog when clicked
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val painter = if (dish.imageUrl != " ") {
                rememberAsyncImagePainter(dish.imageUrl)  // Load network image
            } else {
                painterResource(id = R.drawable.indian_food)  // Load local image for preview
            }
            Image(
                painter = painter,
                contentDescription = dish.dishName,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(6.dp)
                    .size(500.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop // Makes image fill the space


            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = dish.dishName,
                color = BluePrimary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewDishCard() {

    val mydish= Dish("Jeera Rice", " ")
    DishCard(
        mydish,
        onClick = {}
    )
}
