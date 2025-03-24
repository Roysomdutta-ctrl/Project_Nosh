package com.example.recipecompose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipecompose.R
import com.example.recipecompose.ui.theme.BluePrimary

@Composable
fun SearchBar(searchQuery: String, onSearchQueryChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray.copy(alpha = 0.2f))
            .border(2.dp, BluePrimary, RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.CenterStart,

        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            //Search Icon
            Icon(
                painter = painterResource(id = R.drawable.search_blue),
                contentDescription = "Search",
                tint = BluePrimary,
                modifier = Modifier
                    .padding(start=8.dp)
                    .size(30.dp)

            )
            Spacer(modifier = Modifier.width(8.dp))


            if (searchQuery.isEmpty()) {
                Text(
                    text = "Search for dish or ingredient",
                    style = TextStyle(fontSize = 16.sp, color = Color.Gray),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            // Search Text Field
            BasicTextField(
                value = searchQuery,
                onValueChange = { onSearchQueryChange(it) },
                singleLine = true,
                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions.Default,
                modifier = Modifier.fillMaxWidth(),


                )
        }
    }
}