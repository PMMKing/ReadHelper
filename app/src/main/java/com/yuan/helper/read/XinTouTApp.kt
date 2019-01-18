package com.yuan.helper.read

import com.yuan.helper.base.ReadApp2
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/27
 */
class XinTouTApp : ReadApp2() {

    override val page: String
        get() = "com.toutiao.news/.page.news.NewsDetailActivity"
    override val name: String
        get() = "薪头条"
    override val launch: String
        get() = "com.toutiao.news/.page.SplashActivity"
    override val main: String
        get() = "com.toutiao.news/.page.MainActivity"
    override val packages: String
        get() = "com.toutiao.news"

    @Throws(InterruptedException::class)
    override fun launchSub() {}

    @Throws(InterruptedException::class)
    override fun read() {
        Thread.sleep(2000)
        shell.click(Dimen.SCREEN_HEIGHT / 4)
        Thread.sleep(5000)
        val isPage = shell.isPage(0, page)
        if (!isPage) {
            backMain()
            return
        }
        for (index in 0..20) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 2, Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(50))
            Thread.sleep(2000)
        }
        backMain()
    }

    override val page2: String
        get() = "com.toutiao.news/com.lightsky.video.videodetails.ui.activity.VideoDetailsActivity"

    override fun launch2Sub() {
        shell.click(Dimen.SCREEN_WIDTH / 10 * 3, (Dimen.SCREEN_HEIGHT * 0.95677).toInt())
        Thread.sleep(2500)
    }

    override fun read2() {
        Thread.sleep(2000)
        shell.click(Dimen.SCREEN_HEIGHT / 3)
        Thread.sleep(5000)
        val isPage = shell.isPage(0, page)
        if (!isPage) {
            backMain()
            return
        }
        Thread.sleep(40000)
        backMain()
    }


}
