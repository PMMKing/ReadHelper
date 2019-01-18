package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class HaHaApp : ReadApp() {
    override val name: String
        get() = "哈哈小视频"
    override val launch: String
        get() = "com.lswl.qfq/.activity.HaHaSplashActivity"
    override val main: String
        get() = "com.lswl.qfq/.mvp.activity.HomeActivity"
    override val packages: String
        get() = "com.lswl.qfq"
    override val page: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun launchSub() {
        for (i in 0..1) {
            shell.swipeX()
            Thread.sleep(2000)
        }
    }

    override fun read() {
        Thread.sleep(1500)
        shell.swipeY(Dimen.SCREEN_HEIGHT / 4, Dimen.SCREEN_HEIGHT / 4 * 3)
        Thread.sleep(6000)
        for (i in 0..9) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 3 * 2, Dimen.SCREEN_HEIGHT / 3)
            Thread.sleep(4000)
            shell.swipeY(Dimen.SCREEN_HEIGHT / 3, Dimen.SCREEN_HEIGHT / 3 * 2)
            Thread.sleep(4000)
        }
        shell.backPage(4, "", main)
    }

}
