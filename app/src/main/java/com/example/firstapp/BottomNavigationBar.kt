package com.example.firstapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

sealed class BottomNavItem(
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val route: String
) {
    object Lagu : BottomNavItem("Lagu", Icons.Default.Person, "lagu_screen")
    object Favorit : BottomNavItem("Favorit", Icons.Default.Favorite, "favorit_screen")
    object Profil : BottomNavItem("Profil", Icons.Default.Person, "profil_screen")
}

@Composable
fun BottomNavigationBar(
    currentRoute: String,
    onItemSelected: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem.Lagu,
        BottomNavItem.Favorit,
        BottomNavItem.Profil
    )

    NavigationBar(
        containerColor = Color(0xFF8B48B3), // Warna sesuai gambar Anda
        contentColor = Color.White
    ) {
        items.forEach { item ->
            val isSelected = item.route == currentRoute
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(item) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (isSelected) Color.White else Color.LightGray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (isSelected) Color.White else Color.LightGray
                    )
                }
            )
        }
    }
}