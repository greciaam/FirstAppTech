package com.example.firstapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "About",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF8B48B3)
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                modifier = Modifier.height(60.dp)
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Music") },
                    selected = false,
                    onClick = { /* Handle navigation */ },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.White
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorite") },
                    selected = false,
                    onClick = { /* Handle navigation */ },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.White
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    selected = true,
                    onClick = { /* Handle navigation */ },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF8B48B3),
                        indicatorColor = Color.White
                    )
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F5F5)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Image
            Box(
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .size(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_profile),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(60.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            // Profile Information
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ProfileInfoRow("Nama", "Grecia Joy Manalu")
                ProfileInfoRow("Email", "greciajoymanalu02@gmail.com")
                ProfileInfoRow("Universitas", "Politeknik Negeri Batam")
                ProfileInfoRow("Jurusan", "Teknologi Rekayasa Perangkat Lunak")
            }
        }
    }
}

@Composable
private fun ProfileInfoRow(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "$label :",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_5"
)
@Composable
fun AboutScreenPreview() {
    AboutScreen()
}