package com.yuan.helper.read

import android.os.Build
import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen
import java.util.*

/**
 * Created by shucheng.qu on 2018/11/24
 */
class BaoShiXQApp : ReadApp() {
    override val name: String
        get() = "宝石星球"
    override val launch: String
        get() = "com.toomee.stars/.module.splash.SplashActivity"
    override val main: String
        get() = "com.toomee.stars/.module.main.MainActivity"
    override val packages: String
        get() = "com.toomee.stars"
    override val page: String
        get() = "com.toomee.stars/.module.web.NewsWebActivity"

    override fun launchSub() {
        shell.back()
        sleep(4)
        shell.click(Dimen.SCREEN_WIDTH / 10 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(10)
    }

    override fun read() {
        shell.click(Dimen.SCREEN_HEIGHT / 3)
        sleep(5)
        val isPage = shell.isPage(0, page)
        if (!isPage) {
            back()
            return
        }
        for (index in 0..20) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 2, Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(120))
            sleep(3)
        }
        back()
    }

    private fun back() {
        shell.back()
        shell.swipeY(Dimen.SCREEN_HEIGHT / 4 * 3, Dimen.SCREEN_HEIGHT / 2)
        sleep(4)
    }

}
