package com.yuan.helper.utils

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.TextView

import com.yuan.helper.MainApp
import com.yuan.helper.MainApp.mContext
import com.yuan.helper.base.Download
import com.yuan.helper.base.ReadApp


/**
 * Dimensions的缩写
 */
object Dimen {
    val SCREEN_WIDTH: Int
    val SCREEN_HEIGHT: Int


    init {
        val dm = mContext.resources.displayMetrics
        SCREEN_WIDTH = dm.widthPixels
        SCREEN_HEIGHT = dm.heightPixels
    }

    /**
     * dp -> px
     */
    fun dpToPx(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, mContext.resources
                .displayMetrics)
    }

    fun dpToPx(dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), mContext.resources
                .displayMetrics).toInt()
    }

    fun pxToDp(px: Float): Float {
        val scale = mContext.resources.displayMetrics.density
        return px / scale
    }

    /**
     * 像素 float 转 int ; (像素需向上取整)
     */
    fun fi(px: Float): Int {
        return (px + 0.5f).toInt()
    }
}