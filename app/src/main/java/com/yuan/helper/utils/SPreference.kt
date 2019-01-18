package com.yuan.helper.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.yuan.helper.MainApp
import kotlin.reflect.KProperty

/**
 * Created by shucheng.qu on 2018/12/22
 */
object SPreference {
    private val prefs: SharedPreferences = MainApp.mContext.getSharedPreferences("helper", Context.MODE_PRIVATE)

    fun <T> put(key: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(key, value)
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Boolean -> putBoolean(key, value)
            is Float -> putFloat(key, value)
            else -> throw IllegalArgumentException("This type of data cannot be saved!")
        }.apply()
    }

    fun <T> get(key: String, default: T): T = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(key, default)
            is String -> getString(key, default)
            is Int -> getInt(key, default)
            is Boolean -> getBoolean(key, default)
            is Float -> getFloat(key, default)
            else -> throw IllegalArgumentException("This type of data cannot be saved!")
        }
        return res as T
    }
}