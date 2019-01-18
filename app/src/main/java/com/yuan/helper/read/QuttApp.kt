package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class QuttApp : ReadApp() {
    override val packages: String
        get() = "com.jifen.qukan"
    override val page: String
        get() = "NewsDetailActivity"
    override val name: String
        get() = "趣头条"

    override val launch: String
        get() = "com.jifen.qukan/com.jifen.qkbase.main.MainActivity"

    override val main: String
        get() = "com.jifen.qukan/com.jifen.qkbase.main.MainActivity"

    @Throws(InterruptedException::class)
    override fun launchSub() {
        shell.back()
        sleep(4)
        for (i in 0..6) {
            shell.swipeX()
            sleep(3)
        }
    }

    @Throws(InterruptedException::class)
    override fun read() {
        sleep(1)
        shell.click(Dimen.SCREEN_HEIGHT / 4)
        sleep(6)
        val isOpen = shell.isPage(0, page)
        if (!isOpen) {
            backMain()
            return
        }
        for (j in 0..19) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 2, Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(40))
            Thread.sleep(4000)
        }
        backMain()
    }
}
