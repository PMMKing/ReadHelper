package com.yuan.helper.utils

import android.content.Intent
import android.util.Log
import com.yuan.helper.MainApp

import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException

/**
 * Created by shucheng.qu on 2018/11/24
 */
class ShellHelper private constructor() {

    init {
        try {
            val su = Runtime.getRuntime().exec("su")
            dataOutputStream = DataOutputStream(su.outputStream)
            dataInputStream = DataInputStream(su.inputStream)
        } catch (e: IOException) {
            e.printStackTrace()
            LogUtils.logd(e.toString())
        }

    }

    @Throws(InterruptedException::class)
    fun isPage(retry: Int = 0, name: String): Boolean {
        var retry = retry
        topActicity()
        Thread.sleep(1300)
        var readLine = ""
        try {
            val bytes = ByteArray(1024)
            dataInputStream!!.read(bytes)
            readLine = String(bytes)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        LogUtils.logd(readLine)
        return if (!readLine.contains(name)) {
            if (retry > 3) {
                false
            } else isPage(++retry, name)
        } else true
    }


    @Throws(InterruptedException::class)
    fun backPage(name: String, main: String) {
        backPage(0, name, main)
    }

    @Throws(InterruptedException::class)
    fun backPage(retry: Int, name: String, main: String) {
        back()
        Thread.sleep(3000)
        val isBack = isPage(retry, name)
        if (!isBack) {
            startActivity(main)
            Thread.sleep(2000)
        }
    }

    fun click(vararg y: Int) {
        shell(if (y.size == 1) {
            "input tap " + Dimen.SCREEN_WIDTH / 2 + " " + y[0]
        } else if (y.size == 2) {
            "input tap " + y[0] + " " + y[1]
        } else {
            "input tap " + Dimen.SCREEN_WIDTH / 2 + " " + Dimen.SCREEN_HEIGHT / 4
        })
    }

    fun swipeY(vararg y: Int) {
        shell(if (y.size == 2) {
            "input touchscreen swipe ${Dimen.SCREEN_WIDTH / 2} ${y[0]} ${Dimen.SCREEN_WIDTH / 2} ${y[1]} 300"
        } else if (y.size == 3) {
            "input touchscreen swipe ${Dimen.SCREEN_WIDTH / 2} ${y[0]} ${Dimen.SCREEN_WIDTH / 2} ${y[1]} ${y[2]}"
        } else {
            "input touchscreen swipe ${Dimen.SCREEN_WIDTH / 2} ${Dimen.SCREEN_HEIGHT / 2} ${Dimen.SCREEN_WIDTH / 2} ${Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(40)} 300"
        })
    }

    fun swipeX(vararg x: Int) {
        shell(when (x.size) {
            2 -> {
                "input touchscreen swipe ${x[0]} ${Dimen.SCREEN_HEIGHT / 4} ${x[1]} ${Dimen.SCREEN_HEIGHT / 4} 100"
            }
            4 -> {
                "input touchscreen swipe ${x[0]} ${x[1]} ${x[2]} ${x[3]} 100"
            }
            else -> {
                "input touchscreen swipe ${Dimen.SCREEN_WIDTH * 3 / 4} ${Dimen.SCREEN_HEIGHT / 4} ${Dimen.SCREEN_WIDTH / 4} ${Dimen.SCREEN_HEIGHT / 4} 100"
            }
        })
    }

    fun back() {
        shell("input keyevent 4")
    }

    private fun topActicity() {
        shell("dumpsys activity | grep \"mResumedActivity\"")
    }

    fun input(msg: String) {
        LogUtils.logd(msg)
        val intent = Intent("ADB_INPUT_TEXT")
        intent.putExtra("msg", msg)
        MainApp.mContext.sendBroadcast(intent)
    }

    fun startActivity(name: String) {
        shell("am start -n $name")
    }

    fun stopApp(app: String) {
        shell("am force-stop $app")
    }

    fun adbkeyboard() {
        shell("ime set com.android.adbkeyboard/.AdbIME")
    }

    fun sogou() {
        shell("ime set com.sohu.inputmethod.sogou/.SogouIME")
    }

    private fun shell(shell: String) {
        try {
            dataOutputStream!!.writeBytes(shell + "\n")
            dataOutputStream!!.flush()
            LogUtils.logd(shell)
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("HHHH", e.toString())
            LogUtils.logd(shell)
        }

    }

    fun rm(file: String) {
        shell("rm -r $file")
    }

    fun refresh() {
        shell("am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d file:///sdcard/DCIM/aaaa.mp4")
    }

    companion object {

        private var dataOutputStream: DataOutputStream? = null
        private var dataInputStream: DataInputStream? = null
        val shell = ShellHelper()
    }
}
