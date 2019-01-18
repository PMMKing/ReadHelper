package com.yuan.helper.read

import android.os.Build
import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen
import java.util.*

/**
 * Created by shucheng.qu on 2018/11/24
 */
class JinRiTTApp : ReadApp() {
    override val name: String
        get() = "今日头条"
    override val launch: String
        get() = "com.ss.android.article.lite/.activity.SplashActivity"
    override val main: String
        get() = "com.ss.android.article.lite/.activity.MainActivity"
    override val packages: String
        get() = "com.ss.android.article.lite"
    override val page: String
        get() = "com.ss.android.article.lite/com.ss.android.article.base.feature.detail2.view.NewDetailActivity"

    override fun launchSub() {
        setTime(40 * 60)
        shell.back()
        sleep(4)
    }

    override fun read() {
        sleep(2)
        shell.click(Dimen.SCREEN_HEIGHT / 2)
        sleep(3)
        val isPage = shell.isPage(0, page)
        if (!isPage) {
            backMain()
            return
        }
        for (index in 0..10) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 3 * 2, Dimen.SCREEN_HEIGHT / 3, 100)
            sleep(3)
        }
        backMain()
    }

}
