package com.behnamuix.shopflow.features.home.domain.model

data class ProductModel(
    val id: Int, // شناسه یکتا
    val title: String, // عنوان محصول
    val description: String, // توضیحات
    val category: String, // دسته‌بندی
    val price: Double, // قیمت
    val discountPercentage: Double, // درصد تخفیف
    val rating: Double, // امتیاز
    val stock: Int, // موجودی انبار
    val tags: List<String>, // برچسب‌ها
    val brand: String?, // برند (اختیاری)
    val sku: String, // کد انبارداری (SKU)
    val weight: Int, // وزن
    val dimensions: ProductDimensions, // ابعاد محصول
    val warrantyInformation: String, // اطلاعات گارانتی
    val shippingInformation: String, // اطلاعات ارسال
    val availabilityStatus: String, // وضعیت موجودی
    val reviews: List<ProductReview>, // نظرات کاربران
    val returnPolicy: String, // سیاست مرجوعی
    val minimumOrderQuantity: Int, // حداقل تعداد سفارش
    val images: List<String>, // لیست تصاویر
    val thumbnail: String // تصویر بندانگشتی (کوچک)
)

data class ProductDimensions(
    val width: Double, // عرض
    val height: Double, // ارتفاع
    val depth: Double // عمق
)

data class ProductReview(
    val rating: Int, // امتیاز نظر
    val comment: String, // متن نظر
    val date: String, // تاریخ ثبت نظر
    val reviewerName: String, // نام نظردهنده
    val reviewerEmail: String // ایمیل نظردهنده
)