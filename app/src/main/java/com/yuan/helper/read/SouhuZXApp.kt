package com.yuan.helper.read

import com.yuan.helper.base.ReadApp2
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class SouhuZXApp : ReadApp2() {
    override val packages: String
        get() = "com.sohu.infonews"
    override val page: String
        get() = "com.sohu.infonews/com.sohu.quicknews.articleModel.activity.DetailActivity"

    override val name: String
        get() = "搜狐资讯"

    override val launch: String
        get() = "com.sohu.infonews/com.sohu.quicknews.splashModel.activity.SplashActivity"

    override val main: String
        get() = "com.sohu.infonews/com.sohu.quicknews.homeModel.activity.HomeActivity"

    @Throws(InterruptedException::class)
    override fun launchSub() {
        setTime(30 * 60)
        shell.back()
        sleep(4)
        for (i in 0..2) {
            shell.swipeX()
            Thread.sleep(2000)
        }
    }

    @Throws(InterruptedException::class)
    override fun read() {
        Thread.sleep(1000)
        shell.click(Dimen.SCREEN_HEIGHT / 4)
        Thread.sleep(6000)
        val isOpen = shell.isPage(0, page)
        if (!isOpen) {
            backMain()
            return
        }
        for (j in 0..19) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 2, Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(50))
            Thread.sleep(3500)
        }
        backMain()
    }


    override val page2: String
        get() = "HomeActivity"

    override fun launch2Sub() {
        setTime2(20 * 60)
        for (i in 0..1) {
            shell.swipeX()
            Thread.sleep(2000)
        }
    }

    override fun read2() {
        Thread.sleep(2000)
        shell.click(Dimen.SCREEN_HEIGHT / 3)
        Thread.sleep(5000)
        val homeActivity = shell.isPage(3, main)
        if (!homeActivity) {
            backMain()
            return
        }
        sleep(30)
        backMain()
    }
}
