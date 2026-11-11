package com.behnamuix.shopflow.features.home.data.remote.dto



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