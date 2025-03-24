package com.example.recipecompose.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipecompose.R
import com.example.recipecompose.ui.theme.BluePrimary

// Data class for sidebar items
data class SidebarItem(val name: String, val iconRes: Int)

@Composable
fun Sidebar(
    selectedCategory: String,
    //modifier: String = Modifier,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val sidebarWidth = if (expanded) 120.dp else 0.dp

    val sidebarItems = listOf(
        SidebarItem("Cook", R.drawable.grill),
        SidebarItem("Favorites", R.drawable.favourite),
        SidebarItem("Manual", R.drawable.manual),
        SidebarItem("Device", R.drawable.device),
        SidebarItem("Preferences", R.drawable.preferences),
        SidebarItem("Settings", R.drawable.settings)
    )


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
            .padding(vertical = 16.dp)) {

        Spacer(modifier = Modifier.height(12.dp))
        // Sidebar Toggle Button
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                tint = BluePrimary,
                painter = painterResource(id = R.drawable.menu_icon), // Replace with your menu icon
                contentDescription = "Toggle Sidebar",
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp)
            )
        }
        // Sidebar Menu (Collapsible)
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .width(sidebarWidth),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            // Animate Sidebar Visibility
            AnimatedVisibility(
                visible = expanded,
                enter = androidx.compose.animation.expandHorizontally(animationSpec = tween(300)),
                exit = androidx.compose.animation.shrinkHorizontally(animationSpec = tween(300))
            ) {
                Column (){
                    sidebarItems.forEach { item ->
                        SidebarItemRow(item) { onItemSelected(item.name) }
                    }
                }
            }
        }
    }

}

/*   Column(
    modifier = Modifier
        .fillMaxHeight()
        .width(200.dp)
        .background(Color.LightGray.copy(alpha = 0.2f))
        .padding(vertical = 16.dp),
    horizontalAlignment = Alignment.Start
) {
    sidebarItems.forEach { item ->
        SidebarItemRow(item) { onItemSelected(item.name) }
    }
}
}*/

    @Composable
    fun SidebarItemRow(item: SidebarItem, onClick: () -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { onClick() },
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Top
            //verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconRes),
                contentDescription = item.name,
                tint = BluePrimary, // Change the color as needed
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )
            Text(
                text = item.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = BluePrimary
            )
        }
    }



@Preview(showBackground = true)
@Composable
fun PreviewSidebar() {
    Sidebar("Cook"){}
}