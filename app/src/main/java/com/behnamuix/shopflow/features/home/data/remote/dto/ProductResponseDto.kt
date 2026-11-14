package com.behnamuix.shopflow.features.home.data.remote.dto

import com.behnamuix.shopflow.features.home.domain.model.ProductDimensions
import com.behnamuix.shopflow.features.home.domain.model.ProductModel
import com.behnamuix.shopflow.features.home.domain.model.ProductReview

data class ProductResponseDto(
    val products: List<ProductModelDto>,
    val total: Int,
    val skip: Int,
    val limit: Int,
)

fun ProductModelDto.toDomain(): ProductModel = ProductModel(
    id = id,
    title = title,
    description = description,
    category = category,
    price = price,
    discountPercentage = discountPercentage,
    rating = rating,
    stock = stock,
    tags = tags,
    brand = brand,
    sku = sku,
    weight = weight,
    dimensions = dimensions.toDomain(),
    warrantyInformation = warrantyInformation,
    shippingInformation = shippingInformation,
    availabilityStatus = availabilityStatus,
    reviews = reviews.map { it.toDomain() },
    returnPolicy = returnPolicy,
    minimumOrderQuantity = minimumOrderQuantity,
    images = images,
    thumbnail = thumbnail,
)

fun ProductDimensionsDto.toDomain(): ProductDimensions = ProductDimensions(
    width = width,
    height = height,
    depth = depth,
)

fun ProductReviewDto.toDomain(): ProductReview = ProductReview(
    rating = rating,
    comment = comment,
    date = date,
    reviewerName = reviewerName,
    reviewerEmail = reviewerEmail,
)
