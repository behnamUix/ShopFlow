package com.behnamuix.shopflow.features.home.presentation.home

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.behnamuix.shopflow.R
import com.behnamuix.shopflow.features.home.data.remote.dto.home.Category
import com.behnamuix.shopflow.features.home.data.remote.dto.home.FakeCategories
import com.behnamuix.shopflow.features.home.data.remote.dto.home.MainCategory

import com.behnamuix.shopflow.features.home.domain.model.ProductModel
import com.behnamuix.shopflow.ui.theme.Bakh
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onAction(HomeContract.HomeAction.GetProducts)
        viewModel.onAction(HomeContract.HomeAction.GetPhones)
    }

    Scaffold { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            item {
                HeroSection()
            }

            item {
                CategorySection("دسته بندی")
            }

            item {
                PhoneSection("جدیدترین گوشی های تلفن",homeState)
            }

            item {
                NewProductSection(" جدیدترین لوازم آرایشی", homeState)
            }
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
                painter = painterResource(R.drawable.banner2),
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

                                Color(0xF2000000)

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
                            text = "لوازم آرایشی اسنس",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall,

                            textAlign = TextAlign.End,
                            lineHeight = 25.sp,
                            maxLines = 2
                        )

                        Text(
                            text = "زیبایی، به سبک تو",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
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
                            text = "مجموعه ای از محصولات آرایشی و بهداشتی برای زیبایی و جذابیت بیشتر",
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


@Composable
fun CategorySection(
    title: String,
    onCategoryClick: (Category) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)   ,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

       Column(
           Modifier.padding(16.dp),
           verticalArrangement = Arrangement.spacedBy(12.dp)
       ) {
           Text(
               modifier = Modifier.fillMaxWidth(),
               text = title,
               color = Color.White,
               textAlign = TextAlign.Center,
               fontWeight = FontWeight.Bold,
               style = MaterialTheme.typography.titleMedium
           )

           CategoriesScreen()
       }
    }
}

@Composable
fun CategoriesScreen() {

    var selectedCategory by remember {
        mutableIntStateOf(0)
    }

    val categories = FakeCategories.mainCategories

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(380.dp)

    ) {

        // زیر دسته‌ها
        SubCategoriesSection(
            categories = categories[selectedCategory].subCategories,
            modifier = Modifier.weight(1f)
        )
        VerticalDivider(color = Color.LightGray, thickness = 0.5.dp)

        // دسته‌های اصلی
        MainCategoriesSection(
            categories = categories,
            selectedIndex = selectedCategory,
            onCategorySelected = { selectedCategory = it }
        )
    }
}

@Composable
fun MainCategoriesSection(
    categories: List<MainCategory>,
    selectedIndex: Int,
    onCategorySelected: (Int) -> Unit
) {

        LazyColumn(
            modifier = Modifier
                .animateContentSize(tween(1000))
                .width(100.dp)
                .fillMaxHeight()

        ) {

            itemsIndexed(categories) { index, category ->

                val isSelected = selectedIndex == index

                Column(
                    modifier = Modifier

                        .fillMaxWidth()

                        .clickable {
                            onCategorySelected(index)
                        }
                        .padding(vertical = 16.dp, horizontal = 8.dp)

                    ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        shape =  RoundedCornerShape(4.dp)
                    ) {
                        AsyncImage(
                            model = category.image,
                            contentDescription = category.title,
                            modifier = Modifier.size(42.dp),
                            contentScale = ContentScale.Crop
                        )

                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = category.title,
                        color = if (isSelected) Color.White
                        else Color.LightGray,
                        style = MaterialTheme.typography.labelSmall
                    )
                    Spacer(Modifier.height(8.dp))

                    Box(modifier = Modifier.size(6.dp)
                        .background( (if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent), shape = CircleShape))
                }
            }
        }


}

@Composable
fun SubCategoriesSection(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxHeight(),
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(categories) { category ->

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AsyncImage(
                    model = category.image,
                    contentDescription = category.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = category.title,
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
fun NewProductSection(title: String, homeState: HomeContract.HomeState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
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
    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(homeState.products) {
                ProductItemCard(it)
            }
        }
    }

}

@Composable
fun PhoneSection(title: String, homeState: HomeContract.HomeState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
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
    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(homeState.phones) {
                ProductItemCard(it)
            }
        }
    }

}


@Composable
fun ProductItemCard(item: ProductModel) {

    val price = (item.price * 269_000).toLong()

    OutlinedCard(
        modifier = Modifier
            .width(155.dp)
            .height(235.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.White.copy(0.2f)),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {

            // Discount
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Card(
                    shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFF7900)
                    )
                ) {
                    Text(
                        text = "${item.discountPercentage.roundToInt()}٪ تخفیف",
                        modifier = Modifier.padding(
                            horizontal = 5.dp,
                            vertical = 2.dp
                        ),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 9.sp
                        )
                    )
                }
            }

            // Image
            AsyncImage(
                model = item.thumbnail,
                contentDescription = item.title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(vertical = 4.dp)
            )

            // Title
            Text(
                text = item.title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = Color.White,

                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1
            )

            Spacer(Modifier.height(5.dp))

            // Rating and stock
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${item.rating}/5",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 9.sp
                    )
                )

                Spacer(Modifier.weight(1f))

                Card(
                    shape = RoundedCornerShape(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (item.rating > 4)
                            Color(0xFF4CAF50).copy(0.2f)
                        else
                            Color.Red.copy(0.2f)
                    )
                ) {
                    Text(
                        modifier = Modifier.padding(
                            horizontal = 5.dp,
                            vertical = 2.dp
                        ),
                        text = if (item.rating > 4) "موجود" else "ناموجود",
                        color = if (item.rating > 4)
                            Color(0xFF4CAF50)
                        else
                            Color.Red,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 9.sp
                        )
                    )
                }
            }

            Spacer(Modifier.height(7.dp))

            // Price and button
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = NumberFormat
                            .getNumberInstance(Locale.US)
                            .format(price),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 10.sp
                        ),
                        maxLines = 1
                    )

                    Text(
                        "تومان",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 8.sp
                        )
                    )
                }

                VerticalDivider(
                    thickness = 1.dp,
                    color = Color.White,
                    modifier = Modifier.height(18.dp)
                )
                OutlinedButton(
                    enabled = item.rating > 4,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .height(30.dp),
                    contentPadding = PaddingValues(2.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(
                        1.dp,
                        Color(0xFFFF3434)
                    )
                ) {
                    Text(
                        "افزودن",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 9.sp
                        )
                    )
                }

            }
        }
    }
}


@Composable
fun ItemCatCard(category: MainCategory) {

    Column(

        modifier = Modifier.padding(2.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(8.dp)
        ) {
            Surface(shape = CircleShape) {
                AsyncImage(
                    model = category.image,
                    contentScale = ContentScale.Crop,
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                )
            }
            Text(
                category.title,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelMedium,
                color = Color(0xFFB0B0B0)
            )
        }
    }
}


