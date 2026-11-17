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

data class MainCategory(
    val id: Int,
    val title: String,
    val image: String,
    val subCategories: List<Category>
)

data class Category(
    val id: Int,
    val title: String,
    val image: String
)

object FakeCategories {

    val mainCategories = listOf(

        MainCategory(
            id = 1,
            title = "زیبایی و بهداشت",
            image = "https://images.unsplash.com/photo-1596462502278-27bfdc403348?w=400",
            subCategories = listOf(
                Category(1, "زیبایی", "https://images.unsplash.com/photo-1596462502278-27bfdc403348?w=400"),
                Category(2, "عطر و ادکلن", "https://images.unsplash.com/photo-1541643600914-78b084683601?w=400"),
                Category(3, "مراقبت پوست", "https://images.unsplash.com/photo-1608248543803-ba4f8c70ae0b?w=400")
            )
        ),

        MainCategory(
            id = 2,
            title = "پوشاک",
            image = "https://images.unsplash.com/photo-1483985988355-763728e1935b?w=400",
            subCategories = listOf(
                Category(4, "پیراهن مردانه", "https://images.unsplash.com/photo-1596755094514-f87e34085b2c?w=400"),
                Category(5, "کفش مردانه", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=400"),
                Category(6, "لباس زنانه", "https://images.unsplash.com/photo-1483985988355-763728e1935b?w=400"),
                Category(7, "لباس مجلسی", "https://images.unsplash.com/photo-1539008835657-9e8e9680c956?w=400"),
                Category(8, "کفش زنانه", "https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=400")
            )
        ),

        MainCategory(
            id = 3,
            title = "اکسسوری",
            image = "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400",
            subCategories = listOf(
                Category(9, "ساعت مردانه", "https://images.unsplash.com/photo-1524805444758-089113d48a6d?w=400"),
                Category(10, "ساعت زنانه", "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400"),
                Category(11, "عینک آفتابی", "https://images.unsplash.com/photo-1511499767150-a48a237f0083?w=400"),
                Category(12, "کیف زنانه", "https://images.unsplash.com/photo-1584917865442-de89df76afd3?w=400"),
                Category(13, "زیورآلات", "https://images.unsplash.com/photo-1611652022419-a9419f74343d?w=400")
            )
        ),

        MainCategory(
            id = 4,
            title = "دیجیتال",
            image = "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=400",
            subCategories = listOf(
                Category(14, "لپ تاپ", "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=400"),
                Category(15, "گوشی موبایل", "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=400"),
                Category(16, "تبلت", "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=400"),
                Category(17, "لوازم جانبی موبایل", "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400")
            )
        ),

        MainCategory(
            id = 5,
            title = "خانه و آشپزخانه",
            image = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=400",
            subCategories = listOf(
                Category(18, "مبلمان", "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=400"),
                Category(19, "دکوراسیون خانه", "https://images.unsplash.com/photo-1616486338812-3dadae4b4ace?w=400"),
                Category(20, "لوازم آشپزخانه", "https://images.unsplash.com/photo-1556911220-e15b29be8c8f?w=400")
            )
        ),

        MainCategory(
            id = 6,
            title = "سوپرمارکت",
            image = "https://images.unsplash.com/photo-1542838132-92c53300491e?w=400",
            subCategories = listOf(
                Category(21, "مواد غذایی", "https://images.unsplash.com/photo-1542838132-92c53300491e?w=400")
            )
        ),

        MainCategory(
            id = 7,
            title = "وسایل نقلیه",
            image = "https://images.unsplash.com/photo-1492144534655-ae79c964c9d7?w=400",
            subCategories = listOf(
                Category(22, "خودرو", "https://images.unsplash.com/photo-1492144534655-ae79c964c9d7?w=400"),
                Category(23, "موتورسیکلت", "https://images.unsplash.com/photo-1558981806-ec527fa84c39?w=400")
            )
        ),

        MainCategory(
            id = 8,
            title = "ورزش",
            image = "https://images.unsplash.com/photo-1517836357463-d25dfeac3438?w=400",
            subCategories = listOf(
                Category(24, "لوازم ورزشی", "https://images.unsplash.com/photo-1517836357463-d25dfeac3438?w=400")
            )
        )
    )
}
