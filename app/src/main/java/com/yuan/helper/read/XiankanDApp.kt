package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class XiankanDApp : ReadApp() {
    override val packages: String
        get() = "com.xiankandian.meiguibang"
    override val page: String
        get() = "MainActivity"
    override val name: String
        get() = "闲看点"

    override val launch: String
        get() = "com.xiankandian.meiguibang/.MainActivity"

    override val main: String
        get() = "com.xiankandian.meiguibang/.MainActivity"

    @Throws(InterruptedException::class)
    override fun launchSub() {
        shell.back()
        Thread.sleep(2000)
    }

    @Throws(InterruptedException::class)
    override fun read() {
        Thread.sleep(1000)
        shell.swipeY(Dimen.SCREEN_HEIGHT / 3 * 2, Dimen.SCREEN_HEIGHT / 3)
        Thread.sleep(3000)
        shell.click(Dimen.SCREEN_HEIGHT / 4)
        Thread.sleep(35000)
        shell.backPage(page, main)
        Thread.sleep(2000)
    }
}
