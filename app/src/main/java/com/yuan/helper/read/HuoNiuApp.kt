package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class HuoNiuApp : ReadApp() {
    override val name: String
        get() = "火牛视频"
    override val launch: String
        get() = "com.waqu.android.firebull/.ui.LaunchActivity"
    override val main: String
        get() = "com.waqu.android.firebull/.ui.MainActivity"
    override val packages: String
        get() = "com.waqu.android.firebull"
    override val page: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun launchSub() {

    }

    override fun read() {
        shell.swipeY(Dimen.SCREEN_HEIGHT / 3 * 2, Dimen.SCREEN_HEIGHT / 3, 100)
        for (i in 1..4) {
            sleep(5)
            shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(35), (Dimen.SCREEN_HEIGHT * 0.44271).toInt())
        }
        sleep(2)
    }

}
