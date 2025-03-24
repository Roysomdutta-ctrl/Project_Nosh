package com.example.recipecompose.views

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.recipecompose.service.RetrofitInstance
import com.example.recipecompose.ui.theme.RecipeComposeTheme
import kotlinx.coroutines.launch
import androidx.compose.material3.Surface

/**
 * This is a native android app for recipes
 * that uses jetpack compose for UI, retrofit to fetch data
 * coil for image loading
 */


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lifecycleScope.launch {
            try {
                val dishes = RetrofitInstance.api.getDishes()
                Log.d("API_RESPONSE", "Received ${dishes.size} dishes")

                dishes.forEach { dish ->
                    Log.d("API_RESPONSE", "Dish Name: ${dish.dishName}, Image URL: ${dish.imageUrl}")
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Failed to fetch dishes: ${e.message}")
            }
        }
        enableEdgeToEdge()
        setContent {
            RecipeComposeTheme {

                Surface {
                    MainScreen()
                }
/*                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
            }
        }
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecipeComposeTheme {

        MainScreen()

    }
}