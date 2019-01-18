package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/27
 */
class QuduopaiApp : ReadApp() {

    override val name: String
        get() = "趣多拍"
    override val launch: String
        get() = "com.xike.yipai/.view.activity.StartActivity"
    override val main: String
        get() = "com.xike.yipai/.main.activity.MainActivityEx"
    override val packages: String
        get() = "com.xike.yipai"
    override val page: String
        get() = ""

    override fun launchSub() {
        shell.back()
        sleep(3)
    }

    override fun read() {
        shell.swipeY(Dimen.SCREEN_HEIGHT / 4 * 3, Dimen.SCREEN_HEIGHT / 4, 100)
        sleep(15)
    }

}
