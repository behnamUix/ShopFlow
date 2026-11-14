package com.behnamuix.shopflow.features.home.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold

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
import com.behnamuix.shopflow.features.home.data.remote.dto.Category
import com.behnamuix.shopflow.features.home.data.remote.dto.fakeCategories
import com.behnamuix.shopflow.ui.theme.Bakh

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onAction(HomeContract.HomeAction.GetProducts)

    }

    Scaffold() {
        Box(Modifier.padding(it)) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                HeroSection()
                CategorySection("دسته بندی")


            }
        }
    }
}

@Composable
fun CategorySection(
    title: String,

    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "مشاهده همه",

            style = MaterialTheme.typography.labelSmall,
               color = Color(0xFFB0B0B0),
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = title,
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )


    }
    LazyVerticalGrid (columns = GridCells.Fixed(4)) {
        items(fakeCategories) {
            ItemCatCard(it)
        }
    }
}

@Composable
fun ItemCatCard(category: Category) {

    OutlinedCard (

        modifier = Modifier.padding(8.dp), colors = CardDefaults.cardColors(Color(0xFF0D0D0E))) {
       Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
           Image(painter = painterResource(category.image),
               contentScale = ContentScale.Crop,
               contentDescription = "",
               modifier = Modifier.fillMaxWidth().height(60.dp))
           Text(
               category.title,
               textAlign = TextAlign.Center,
               style = MaterialTheme.typography.bodySmall,
               color = Color(0xFFB0B0B0))
       }
    }
}

@Composable
fun HeroSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
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
                        .fillMaxWidth(0.80f)
                        .align(Alignment.CenterEnd)
                        .padding(16.dp),

                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    // Discount Badge
                    OutlinedCard(
                        border = BorderStroke(1.dp, color = Color.White),
                        colors = CardDefaults.cardColors(Color.Transparent),
                        shape = RoundedCornerShape(bottomEnd = 16.dp, topStart = 16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "تخفیف ویژه",

                                color = Color.White,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                "%",
                                textAlign = TextAlign.Center,
                                fontFamily = Bakh,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                    }

                    // Main Title
                    Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            text = "لپ تاب گیمینگ",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall,

                            textAlign = TextAlign.End,
                            lineHeight = 25.sp,
                            maxLines = 2
                        )

                        Text(
                            text = "قدرت در دستان شما",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.End,
                            lineHeight = 25.sp,
                            maxLines = 2
                        )
                    }

                    // Description
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .height(20.dp)
                                .width(2.dp)
                                .background(
                                    MaterialTheme.colorScheme.primary
                                )
                        )
                        Text(
                            text = "عملکرد فوق العاده مناسب برای بازی و کار حرفه ای",
                            color = Color(0xFFB0B0B0),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Start,
                            lineHeight = 16.sp,
                            maxLines = 2
                        )
                    }

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
                            text = "←",
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "مشاهده محصول",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )

                    }
                }
            }
        }
    }
}

