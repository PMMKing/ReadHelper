package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen
import com.yuan.helper.utils.ShellHelper.Companion.shell

/**
 * Created by shucheng.qu on 2018/11/24
 */
class TaoXinWenApp : ReadApp() {
    override val packages: String
        get() = "com.coohua.xinwenzhuan"
    override val page: String
        get() = ""
    override val name: String
        get() = "淘新闻"

    override val launch: String
        get() = "com.coohua.xinwenzhuan/.controller.MainActivity"

    override val main: String
        get() = "com.coohua.xinwenzhuan/.controller.MainActivity"

    @Throws(InterruptedException::class)
    override fun launchSub() {
        shell.back()
        sleep(4)
        shell.swipeX()
        sleep(3)
    }

    @Throws(InterruptedException::class)
    override fun read() {
        sleep(1)
        shell.click(Dimen.SCREEN_HEIGHT / 4)
        sleep(3)
        val isOpen = shell.isPage(0, main)
        if (!isOpen) {
            backMain()
            return
        }
        for (j in 0..10) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 3 * 2, Dimen.SCREEN_HEIGHT / 3)
            sleep(2)
        }
        backMain()
    }
}
