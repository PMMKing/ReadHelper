package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class HaicaoGSApp : ReadApp() {
    override val name: String
        get() = "海草公社"
    override val launch: String
        get() = "com.billionstech.grassbook/.business.launcher.LauncherActivity"
    override val main: String
        get() = "com.billionstech.grassbook/.business.main.MainActivity"
    override val packages: String
        get() = "com.billionstech.grassbook"
    override val page: String
        get() = "FindDetailActivity"

    override fun launchSub() {
        shell.back()
        Thread.sleep(2000)
    }

    override fun read() {
        Thread.sleep(2000)
        shell.click(Dimen.SCREEN_HEIGHT / 3)
        Thread.sleep(6000)
        val isOpen = shell.isPage(0, "FindDetailActivity")
        if (!isOpen) {
            backMain()
            return
        }
        for (j in 0..19) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 2, Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(40))
            Thread.sleep(2000)
        }
        backMain()
    }

}
