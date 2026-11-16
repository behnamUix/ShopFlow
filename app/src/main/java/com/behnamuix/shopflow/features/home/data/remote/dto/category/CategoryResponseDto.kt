package com.behnamuix.shopflow.features.home.data.remote.dto.category

import com.behnamuix.shopflow.features.home.domain.model.CategoryModel

data class CategoryResponseDto(
    val categories: List<CategoryDto>,
)

fun CategoryDto.toDomain(): CategoryModel = CategoryModel(
    slug = this.slug,
    name = this.name,
    url = this.url


)

