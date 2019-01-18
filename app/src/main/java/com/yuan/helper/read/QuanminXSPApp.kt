package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class QuanminXSPApp : ReadApp() {
    override val name: String
        get() = "全民小视频"
    override val launch: String
        get() = "com.baidu.minivideo/.app.activity.splash.SplashActivity"
    override val main: String
        get() = "com.baidu.minivideo/.app.activity.HomeActivity"
    override val packages: String
        get() = "com.baidu.minivideo"
    override val page: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun launchSub() {
        shell.click(Dimen.SCREEN_WIDTH / 4, Dimen.SCREEN_HEIGHT / 4)
        Thread.sleep(3000)
        setTime(40 * 60)
    }

    override fun read() {
        Thread.sleep(20000)
        shell.swipeY(Dimen.SCREEN_HEIGHT * 3 / 4, Dimen.SCREEN_HEIGHT / 4, 100)
        Thread.sleep(3000)
    }

}
