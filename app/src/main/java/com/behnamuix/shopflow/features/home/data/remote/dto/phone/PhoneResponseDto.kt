package com.behnamuix.shopflow.features.home.data.remote.dto.phone

import com.behnamuix.shopflow.features.home.domain.model.PhoneModel

data class PhoneResponseDto(
    val products: List<PhoneModelDto>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
fun PhoneModelDto.toDomain(): PhoneModel = PhoneModel(
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
    warrantyInformation = warrantyInformation,
    shippingInformation = shippingInformation,
    availabilityStatus = availabilityStatus,
    returnPolicy = returnPolicy,
    minimumOrderQuantity = minimumOrderQuantity,
    images = images,
    thumbnail = thumbnail
)