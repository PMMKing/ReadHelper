package com.yuan.helper.read

import android.os.Build
import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen
import java.util.*

/**
 * Created by shucheng.qu on 2018/11/24
 */
class SanYanApp : ReadApp() {
    override val name: String
        get() = "三言"
    override val launch: String
        get() = "com.sylife/.activity.StartActivity"
    override val main: String
        get() = "com.sylife/.activity.MainActivity"
    override val packages: String
        get() = "com.sylife"
    override val page: String
        get() = "com.sylife/.activity.article.ArticleWebViewActivity"

    override fun launchSub() {
        shell.back()
        sleep(4)
        shell.adbkeyboard()
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
        for (index in 0..5) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 3*2, Dimen.SCREEN_HEIGHT / 3,100)
            sleep(2)
        }
        shell.click(Dimen.SCREEN_WIDTH-Dimen.dpToPx(76),Dimen.SCREEN_HEIGHT-Dimen.dpToPx(27))
        sleep(2)
        shell.click(Dimen.SCREEN_WIDTH/2,Dimen.SCREEN_HEIGHT-Dimen.dpToPx(27))
        sleep(2)
        shell.input("真是太好看了，超级好看啊! ${Random().nextInt(9999999)}")
        sleep(2)
        shell.click(Dimen.SCREEN_WIDTH-Dimen.dpToPx(46),Dimen.SCREEN_HEIGHT-Dimen.dpToPx(27))
        sleep(2)
        backMain()
    }

}
