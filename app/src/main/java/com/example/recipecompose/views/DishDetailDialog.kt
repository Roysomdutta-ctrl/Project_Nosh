package com.example.recipecompose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.recipecompose.service.Dish
import com.example.recipecompose.ui.theme.OrrangePrimary
import com.example.recipecompose.ui.theme.BluePrimary

@Composable
fun DishDetailDialog(
    dish: Dish,
    onDismiss: () -> Unit
) {
    var selectedHour by remember { mutableStateOf(12) }
    var selectedMinute by remember { mutableStateOf(0) }
    var isAM by remember { mutableStateOf(true) } // true=AM and false=PM
    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                
                Text(
                    text = "Schedule Cooking Time",
                    fontSize = 20.sp,
                    style = TextStyle(fontSize = 18.sp, color = BluePrimary,fontWeight = FontWeight.Bold),
                )

                Spacer(modifier = Modifier.height(16.dp))

                //Scrollable Time Picker
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    //Scrollable Hour Picker
                    NumberPicker(
                        range = (1..12).toList(),
                        selectedValue = selectedHour,
                        onValueChange = { selectedHour = it }
                    )

                    Text(":", fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterVertically))

                    //Scrollable Minute Picker
                    NumberPicker(
                        range = (0..59).toList(),
                        selectedValue = selectedMinute,
                        onValueChange = { selectedMinute = it }
                    )

                    //AM/PM Selector
                    Column {
                        Text(
                            text = if (isAM) "AM" else "PM",
                            fontSize = 20.sp,
                            color = BluePrimary,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Switch(
                            checked = !isAM,
                            onCheckedChange = { isAM = !it }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Button(
                        onClick = { /* Delete Action */ },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        modifier = Modifier
                                .weight(1f)
                            .height(40.dp),
                        contentPadding = PaddingValues(8.dp)

                    ) {
                        //Text("Delete", fontSize =  14.sp)
                        Text("Delete",
                            color = Color.Red,
                            maxLines = 1,
                            softWrap = false,
                            fontSize = 10.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center)
                    }

                    Button(
                        modifier = Modifier
                            .border(2.dp, OrrangePrimary, RoundedCornerShape(20.dp))
                            .weight(1f)
                            .height(40.dp),
                        onClick = { /* Reschedule Action */ },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        Text("Re-schedule", color = OrrangePrimary,
                            maxLines = 1,
                            softWrap = false,
                            fontSize = 10.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center)
                    }

                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp),
                        onClick = { /* Cook Now Action */ },
                        colors = ButtonDefaults.buttonColors(OrrangePrimary),
                        shape = RoundedCornerShape(10.dp,),
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        Text("Cook Now",
                                maxLines = 1,
                            softWrap = false,
                            fontSize = 10.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center)

                    }
                }
            }
        }
    }
}


@Composable
fun NumberPicker(
    range: List<Int>,
    selectedValue: Int,
    onValueChange: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .height(100.dp)
            .width(60.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(range) { value ->
                Text(
                    text = value.toString().padStart(2, '0'),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = BluePrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(if (value == selectedValue) Color.LightGray else Color.Transparent)
                        .clickable { onValueChange(value) },
                )
            }
        }
    }
}









@Preview(showBackground = true)
@Composable
fun PreviewDishDetailDialog() {
    val showDish=Dish("Jeera rice"," ")
    DishDetailDialog(showDish){}
}