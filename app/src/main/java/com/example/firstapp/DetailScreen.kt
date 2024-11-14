package com.example.firstapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(  // Menggunakan CenterAlignedTopAppBar
                title = {
                    Text(
                        "Detail Lagu",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation */ }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF8B48B3)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF8B48B3)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Album Art
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .size(300.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder_album),
                    contentDescription = "Album Art",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // Song Details
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                DetailRow("Judul", "Tampar")
                DetailRow("Penyanyi", "Lazy Lucy")
                DetailRow("Penulis", "Demo Lagu dan Iqbal Siregat")
                DetailRow("Rilis", "8 April 2022")
                DetailRow("Lirik", buildLyrics())
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

private fun buildLyrics(): String {
    return """
        Entah sudah Selasa yang ke berapa
        Masih saja kau ada lekat di kepala
        Hari ini janji esok pasti lupa
        Tetapi hati tak tepati
        Tampar aku di pipi Biar sadar dan ku mengerti

        Hujan samarkan derasnya tutup air mata
        Temani kecewa ku yg t'lah lama
        Berdosa kah ku berdoa
        Minta kau terluka dan tinggalkan dirinya
        Hari ini janji esok pasti lupa
        Tetapi hati tak tepati
        Tampar aku di pipi Biar sadar dan ku mengerti

        Hujan samarkan derasnya tutup air mata
        Temani kecewa ku yg t'lah lama
        Berdosa kah ku berdoa
        Minta kau terluka dan tinggalkan dirinya
        
        Bukan ku tak berupaya

        Hujan samarkan derasnya tutup air mata
        Temani kecewa ku yg t'lah lama
        Berdosa kah ku berdoa
        Minta kau terluka dan tinggalkan dirinya
        
        Hujan samarkan derasnya 
        Tutup air mata
        Tiga tahun tak terasa masih kau yang ada
        Bodoh yang sebenarnya

        Tampar aku di pipi
        Sadarkan kau aku tak kan terjadi
    """.trimIndent()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetailScreen() {
    DetailScreen()
}