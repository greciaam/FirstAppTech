package com.example.firstapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.BottomNavigationBar
import com.example.firstapp.R
import com.example.firstapp.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorit") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Purple80)
            )
        },
        bottomBar = { BottomNavigationBar(selectedTab = "favorites") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Lagu yang disukai",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Grid untuk menampilkan daftar album
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize(),
                content = {
                    items(10) { // Jumlah item contoh (10 item)
                        FavoriteSongItem()
                    }
                }
            )
        }
    }
}

@Composable
fun FavoriteSongItem() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(150.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.placeholder_song),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}