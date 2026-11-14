package com.behnamuix.shopflow.features.home.data.remote.dto

import com.behnamuix.shopflow.R


data class ProductModelDto(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val tags: List<String>,
    val brand: String?,
    val sku: String,
    val weight: Int,
    val dimensions: ProductDimensionsDto,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: List<ProductReviewDto>,
    val returnPolicy: String,
    val minimumOrderQuantity: Int,
    val images: List<String>,
    val thumbnail: String
)

data class ProductDimensionsDto(
    val width: Double,
    val height: Double,
    val depth: Double
)
data class ProductReviewDto(
    val rating: Int,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String
)
data class Category(
    val id: Int,
    val title: String,
    val image: Int
)

val fakeCategories = listOf(
    Category(1, "موبایل", R.drawable.phone),
    Category(2, "لپ‌تاپ", R.drawable.laptop),
    Category(3, "کنسول بازی", R.drawable.console),
    Category(4, "هدفون", R.drawable.headphone),
    Category(5, "ساعت هوشمند", R.drawable.smart_watch),
    Category(6, "تبلت", R.drawable.tablet),
    Category(7, "مانیتور", R.drawable.monitor),
    Category(8, "کیبورد", R.drawable.keyboard),
    Category(9, "ماوس", R.drawable.mouse),
    Category(10, "اسپیکر", R.drawable.speaker),
    Category(11, "دوربین", R.drawable.camera),
    Category(12, "لوازم جانبی", R.drawable.lavazem_janebi)
)