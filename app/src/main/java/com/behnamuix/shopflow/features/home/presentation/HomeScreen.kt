package com.behnamuix.shopflow.features.home.presentation

import android.util.Log
import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.behnamuix.shopflow.R

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onAction(HomeContract.HomeAction.GetProducts)

    }

    Scaffold () {
        Box(Modifier.padding(it)) {
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(215.dp)
                        .padding(horizontal = 8.dp),
                    shape = RoundedCornerShape(22.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {

                    Box(modifier = Modifier.fillMaxSize()) {

                        // Background Image
                        Image(
                            painter = painterResource(R.drawable.banner),
                            contentDescription = "Gaming Laptop",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        // Dark Gradient Overlay
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            Color.Transparent,

                                            Color(0xE2000000)

                                        )
                                    )
                                )
                        )

                        // Left Content
                        CompositionLocalProvider(
                            LocalLayoutDirection provides LayoutDirection.Ltr
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.58f)
                                    .align(Alignment.CenterEnd)
                                    .padding(16.dp),

                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {

                                // Discount Badge
                                Surface(
                                    color = Color(0xFFE50914),
                                    shape = RoundedCornerShape(50)
                                ) {
                                    Text(
                                        text = "تخفیف ویژه",
                                        modifier = Modifier.padding(
                                            horizontal = 12.dp,
                                            vertical = 5.dp
                                        ),
                                        color = Color.White,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                // Main Title
                                Column(
                                    horizontalAlignment = Alignment.End,
                                    verticalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    Text(
                                        text = "لپ تاب گیمینگ",
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.End,
                                        lineHeight = 25.sp,
                                        maxLines = 2
                                    )

                                    Text(
                                        text = "قدرت در دستان شما",
                                        color = MaterialTheme.colorScheme.primary,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.End,
                                        lineHeight = 25.sp,
                                        maxLines = 2
                                    )
                                }

                                // Description
                                Text(
                                    text = "عملکرد فوق العاده مناسب برای بازی و کار حرفه ای",
                                    color = Color(0xFFE0DDE0),
                                   style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Start,
                                    lineHeight = 16.sp,
                                    maxLines = 2
                                )

                                // CTA Button
                                Button(
                                    onClick = {},
                                    modifier = Modifier.height(38.dp),
                                    shape = RoundedCornerShape(50),
                                    colors = ButtonDefaults.buttonColors(

                                        contentColor = Color.White
                                    ),
                                    contentPadding = PaddingValues(
                                        horizontal = 14.dp,
                                        vertical = 4.dp
                                    )
                                ) {
                                    Text(
                                        text = "مشاهده محصول",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(modifier = Modifier.width(6.dp))

                                    Text(
                                        text = "←",
                                        fontSize = 16.sp
                                    )
                                }
                            }
                        }
                    }
                }


            }
        }
    }
}

