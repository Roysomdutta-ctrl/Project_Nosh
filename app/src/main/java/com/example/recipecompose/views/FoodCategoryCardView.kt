package com.example.recipecompose.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipecompose.models.FoodCategory
import com.example.recipecompose.ui.theme.BluePrimary



@Composable
fun FoodCategoryCardView(food: FoodCategory) {
    Card(
        modifier = Modifier
            .width(200.dp) // Rectangular shape
            .height(80.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(40.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = food.imageRes),
                contentDescription = food.name,
                modifier = Modifier
                    .size(60.dp) // Set fixed size for the image
                    .clip(RoundedCornerShape(30.dp)), // Round edges for image
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp)) // Space between image & text

            //Food Name (Right)
            Text(
                text = food.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = BluePrimary
            )
        }
    }
}

/*@Composable
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
*/


@Preview(showBackground = true)
@Composable
fun PreviewIndianFoodRow() {
    IndianFoodRow()
}
