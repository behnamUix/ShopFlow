package com.behnamuix.shopflow.features.home.domain.model



data class ProductModel(
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
    val dimensions: ProductDimensions,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: List<ProductReview>,
    val returnPolicy: String,
    val minimumOrderQuantity: Int,
    val images: List<String>,
    val thumbnail: String
)

data class ProductDimensions(
    val width: Double,
    val height: Double,
    val depth: Double
)
data class ProductReview(
    val rating: Int,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String
)