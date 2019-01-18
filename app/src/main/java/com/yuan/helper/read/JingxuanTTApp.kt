package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class JingxuanTTApp : ReadApp() {
    override val name: String
        get() = "精选头条"
    override val launch: String
        get() = "com.deshang.ttjx/.ui.login.activity.WelcomeActivity"
    override val main: String
        get() = "com.deshang.ttjx/.ui.main.activity.MainActivity"
    override val packages: String
        get() = "com.deshang.ttjx"
    override val page: String
        get() = "com.deshang.ttjx/.ui.tab4.activity.NewsDetailCircleActivity"

    override fun launchSub() {
        for (i in 0..2) {
            shell.swipeX()
            Thread.sleep(2000)
        }
    }

    override fun read() {
        sleep(2)
        shell.click(Dimen.SCREEN_HEIGHT / 3)
        sleep(5)
        val isPage = shell.isPage(0, page)
        if (!isPage) {
            backMain()
            return
        }
        for (index in 0..21) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 2, Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(50))
            Thread.sleep(2800)
        }
        backMain()
    }

}
