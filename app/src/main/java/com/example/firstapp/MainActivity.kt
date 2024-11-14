package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import com.example.firstapp.ui.theme.FirstAppTheme
import com.example.firstapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = { BottomNavigationBar(selectedTab = "music") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Lagu",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            LazyColumn {
                item {
                    Text(
                        text = "Lagu galau",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    LazyRow {
                        items(5) {
                            SongThumbnail()
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Rekomendasi lagu",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Column { this@LazyColumn.item (key = 3) { RecommendedSongCard() } }
                }
            }
        }
    }
}

@Composable
fun SongThumbnail() {
    Card(
        modifier = Modifier
            .size(150.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.placeholder_song),
            contentDescription = "Song Thumbnail",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun RecommendedSongCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.placeholder_recommended),
            contentDescription = "Recommended Song",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun BottomNavigationBar(selectedTab: String = "music") {
    NavigationBar(
        containerColor = Color(0xFFD8BFD8)
    ) {
        NavigationBarItem(
            selected = selectedTab == "music",
            onClick = { /* Navigasi ke layar music */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_music_note),
                    contentDescription = "Music"
                )
            },
            label = { Text(text = "Music", fontSize = 12.sp) }
        )
        NavigationBarItem(
            selected = selectedTab == "favorites",
            onClick = { /* Navigasi ke layar favorit */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.placeholder2_album),
                    contentDescription = "Favorites"
                )
            },
            label = { Text(text = "Favorites", fontSize = 12.sp) }
        )
        NavigationBarItem(
            selected = selectedTab == "account",
            onClick = { /* Navigasi ke layar akun */ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_account),
                    contentDescription = "Account"
                )
            },
            label = { Text(text = "Account", fontSize = 12.sp) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstAppTheme {
        MainScreen()
    }
}