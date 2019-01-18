package com.yuan.helper

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder

import com.yuan.helper.window.HelperView

/**
 * Created by shucheng.qu on 2018/11/11
 */
class HelperService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        showFloatingWindow()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun showFloatingWindow() {
        // 新建悬浮窗控件
        HelperView(this)
    }

}
