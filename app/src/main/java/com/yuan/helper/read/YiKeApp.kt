package com.yuan.helper.read

import android.os.Build
import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class YiKeApp : ReadApp() {
    override val name: String
        get() = "亿刻"
    override val launch: String
        get() = "com.cnode.blockchain/.splash.SplashActivity"
    override val main: String
        get() = "com.cnode.blockchain/.MainActivity"
    override val packages: String
        get() = "com.cnode.blockchain"
    override val page: String
        get() = "com.cnode.blockchain/.detail.DetailActivity"

    override fun launchSub() {
        for (i in 0..1) {
            shell.swipeX()
            Thread.sleep(2000)
        }
        Build.MODEL
    }

    override fun read() {
        Thread.sleep(2000)
        shell.click(Dimen.SCREEN_HEIGHT / 3)
        Thread.sleep(5000)
        val isPage = shell.isPage(0, page)
        if (!isPage) {
            backMain()
            return
        }
        for (index in 0..5) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 2, Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(150))
            Thread.sleep(2000)
        }
        backMain()
    }

}
