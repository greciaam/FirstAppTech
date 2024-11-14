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
fun DetailScreen2() {
    Scaffold(
        topBar = {
            TopAppBar(
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
                    .background(Color.Black)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder2_album),
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
                DetailRow("Judul", "HAHAHA")
                DetailRow("Penyanyi", "Kita Lucy")
                DetailRow("Penulis", "Demo Lagu dan Iqbal Siregat")
                DetailRow("Rilis", "30 Januari 2024")
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
        Saat kau senang ku pasti kau lupakan
        Saat tak tenang tebak siapa yang datang
        Rindu kau bilang, saat kau kesepian
        Lain kemarin, lain sekarang

        Cerita malammu bersamanya
        Kudengarkan walau tahan air mata

        HAHAHA ku tertawa padahal sakit 
        sebenarnya
        Bisa bisanya kau anggap ku bahagia
        Tak jelaskah ku kecewa

        Lebih piawai dari peraih piala
        Citra kujaga, sampai kapan ku bisa?

        Katamu tak ada yang sepertinya
        Apa kau lupa siapa yang selalu ada?

        HAHAHA ku tertawa padahal sakit 
        sebenarnya
        Bisa bisanya kau anggap ku bahagia
        Tak jelaskah ku kecewa

        Pergi... ku harus segera pergi...
        Tapi kau pikat aku... lagi...

        HAHAHA ku tertawa padahal sakit 
        sebenarnya
        Bisa bisanya kau anggap ku bahagia
        Tak jelaskah ku kecewa
        Sekuat-kuatnya, tak mungkin selamanya, toh 
        kita manusia
        Bisa tak bisa ujungnya ku harus rela
        Biarpun aku kecewa

        HAHAHAHAHAHAHA
    """.trimIndent()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetailScreen2() {
    DetailScreen2()
}