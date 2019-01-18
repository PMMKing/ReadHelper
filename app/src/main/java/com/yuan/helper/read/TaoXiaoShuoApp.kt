package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/28
 */
class TaoXiaoShuoApp : ReadApp() {
    override val page: String
        get() = "com.cashtoutiao/.news.ui.NewsDetailActivity"
    override val name: String
        get() = "淘小说"
    override val launch: String
        get() = "com.martian.ttbook/com.martian.mibook.activity.EnterActivity"
    override val main: String
        get() = "com.martian.ttbook/com.martian.mibook.activity.Homepage"
    override val packages: String
        get() = "com.martian.ttbook"

    @Throws(InterruptedException::class)
    override fun launchSub() {
        setTime(6 * 60 * 60)
        shell.click(Dimen.SCREEN_WIDTH / 8 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(6)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.dpToPx(320))
        sleep(6)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(6)
    }

    @Throws(InterruptedException::class)
    override fun read() {
        for (i in 0..100){
            shell.swipeX(Dimen.SCREEN_WIDTH / 4 * 3, Dimen.SCREEN_WIDTH / 4, Dimen.SCREEN_HEIGHT / 4, Dimen.SCREEN_HEIGHT / 4 * 3)
            sleep(20)
        }
        for (i in 0..100){
            shell.swipeX(Dimen.SCREEN_WIDTH / 4, Dimen.SCREEN_WIDTH / 4*3, Dimen.SCREEN_HEIGHT / 4, Dimen.SCREEN_HEIGHT / 4 * 3)
            sleep(20)
        }
    }
}
