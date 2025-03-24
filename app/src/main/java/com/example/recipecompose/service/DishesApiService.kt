package com.example.recipecompose.service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * The below is a data class which will Will
 * act as the model for the incoming data
 */
data class Dish(val dishName: String, val imageUrl: String)


/**
 * The following is the API interface which will be used to receive data
 * using the API call
 */
interface DishesApiService {
    @GET("nosh-assignment")
    suspend fun getDishes(): List<Dish>
}

/**
 * Here’s a simple implementation of a Retrofit instance class in Kotlin,
 * following the Singleton pattern to ensure only one instance of Retrofit is created.
 */
object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fls8oe8xp7.execute-api.ap-south-1.amazonaws.com/dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: DishesApiService = retrofit.create(DishesApiService::class.java)
}