package com.yuan.helper.net

import android.os.Parcel
import android.os.Parcelable
import com.yuan.helper.utils.LogUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by shucheng.qu on 2018/12/10
 */
object OkHttp {

    val client = OkHttpClient.Builder()
            .connectTimeout(20L, TimeUnit.SECONDS)
            .readTimeout(40L, TimeUnit.SECONDS)
            .addInterceptor(getInterceptor())
            .build()


    private fun getInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> LogUtils.logd(message) })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return httpLoggingInterceptor
    }
}
