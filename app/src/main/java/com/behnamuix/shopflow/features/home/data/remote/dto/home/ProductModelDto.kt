package com.behnamuix.shopflow.features.home.data.remote.dto.home

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
    val image: String
)

val fakeCategories = listOf(
    Category(
        1,
        "آرایش صورت",
        "https://images.unsplash.com/photo-1522335789203-aabd1fc54bc9?w=400"
    ),
    Category(
        2,
        "آرایش چشم",
        "https://images.unsplash.com/photo-1512496015851-a90fb38ba796?w=400"
    ),
    Category(
        3,
        "رژ لب",
        "https://images.unsplash.com/photo-1586495777744-4413f21062fa?w=400"
    ),
    Category(
        4,
        "مراقبت پوست",
        "https://images.unsplash.com/photo-1608248543803-ba4f8c70ae0b?w=400"
    ),
    Category(
        5,
        "مراقبت مو",
        "https://images.unsplash.com/photo-1527799820374-dcf8d9d4a388?w=400"
    ),
    Category(
        6,
        "عطر و ادکلن",
        "https://images.unsplash.com/photo-1594035910387-fea47794261f?w=400"
    ),
    Category(
        7,
        "ناخن",
        "https://images.unsplash.com/photo-1604654894610-df63bc536371?w=400"
    ),
    Category(
        8,
        "براش و ابزار آرایشی",
        "https://images.unsplash.com/photo-1522335789203-aabd1fc54bc9?w=400"
    ),
    Category(
        9,
        "ضد آفتاب",
        "https://images.unsplash.com/photo-1556229010-6c3f2c9ca5f8?w=400"
    ),
    Category(
        10,
        "ماسک و پاک‌کننده",
        "https://images.unsplash.com/photo-1570172619644-dfd03ed5d881?w=400"
    ),
    Category(
        11,
        "لوازم اصلاح",
        "https://images.unsplash.com/photo-1621607512214-68297480165e?w=400"
    ),
    Category(
        12,
        "لوازم بهداشتی",
        "https://images.unsplash.com/photo-1556228720-195a672e8a03?w=400"
    )
)