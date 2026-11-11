package com.behnamuix.shopflow.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitProvider {

    // آدرس اصلی سرور (Base URL)
    private const val BASE_URL = "https://dummyjson.com/"

    // اینترسپتور لاگ‌گیری برای نمایش اطلاعات درخواست و پاسخ در Logcat
    // برای جلوگیری از تایم‌اوت سوکت موقع خواندن بدنه کامل پاسخ، لول لاگ روی HEADERS یا BASIC قرار می‌گیرد
    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }
    }

    // ساخت OkHttpClient با تایم‌اوت مناسب و تنظیمات شبکه
    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()

                    .build()
                chain.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .retryOnConnectionFailure(true)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    // ساخت نمونه اصلی Retrofit
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // تابع عمومی کمکی برای ساخت ApiServiceهای مختلف در هر فیچر
    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}
