package com.example.recipecompose.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipecompose.models.Suggestion

@Composable
fun Suggestions() {
    val suggestionList = listOf(
        Suggestion("Explore all dishes"),
        Suggestion("Confused what to cook?"),

    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(suggestionList) { suggestion ->
            SuggestionCardView(suggestion)
        }
    }
}


