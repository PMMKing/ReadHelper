package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/28
 */
class HuiToutAPP : ReadApp() {
    override val page: String
        get() = "com.cashtoutiao/.news.ui.NewsDetailActivity"
    override val name: String
        get() = "惠头条"
    override val launch: String
        get() = "com.cashtoutiao/.common.ui.SplashActivity"
    override val main: String
        get() = "com.cashtoutiao/.account.ui.main.MainTabActivity"
    override val packages: String
        get() = "com.cashtoutiao"

    @Throws(InterruptedException::class)
    override fun launchSub() {
        for (i in 0..1) {
            shell.swipeX()
            sleep(3)
        }
        shell.swipeY(Dimen.SCREEN_HEIGHT / 3 * 2, Dimen.SCREEN_HEIGHT / 3)
        sleep(3)
    }

    @Throws(InterruptedException::class)
    override fun read() {
        Thread.sleep(1000)
        shell.click(Dimen.SCREEN_HEIGHT / 2)
        Thread.sleep(5000)
        val isPage = shell.isPage(0, page)
        if (!isPage) {
            backMain()
            return
        }
        for (index in 0..15) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 2, Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(100))
            Thread.sleep(3000)
        }
        backMain()
    }
}
