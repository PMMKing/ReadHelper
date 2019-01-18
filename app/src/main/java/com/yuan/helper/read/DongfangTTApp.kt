package com.yuan.helper.read

import com.bugtags.library.obfuscated.s
import com.yuan.helper.base.ReadApp2
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/24
 */
class DongfangTTApp : ReadApp2() {
    override val name: String
        get() = "东方头条"
    override val launch: String
        get() = "com.songheng.eastnews/com.oa.eastfirst.activity.WelcomeActivity";
    override val main: String
        get() = "com.songheng.eastnews/com.songheng.eastfirst.common.view.activity.MainActivity";
    override val packages: String
        get() = "com.songheng.eastnews"
    override val page: String
        get() = "com.songheng.eastnews/com.songheng.eastfirst.business.newsdetail.view.activity.NewsDetailH5Activity"

    override fun launchSub() {
        shell.back()
        sleep(2)
        shell.swipeX()
        sleep(2)
        backMain()
    }

    override fun read() {
        sleep(1)
        shell.click(Dimen.SCREEN_HEIGHT / 3)
        sleep(5)
        val page1 = shell.isPage(0, page)
        if (!page1){
            backMain()
            return
        }
        for (j in 0..18) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 2, Dimen.SCREEN_HEIGHT / 2 - Dimen.dpToPx(100))
            sleep(2)
        }
        backMain()
    }

    override val page2: String
        get() = "com.songheng.eastnews/com.songheng.eastfirst.business.video.view.activity.VideoDetailActivity"

    override fun launch2Sub() {
        shell.back()
        sleep(2)
        for (i in 0..1) {
            shell.swipeX()
            sleep(2)
        }
    }

    override fun read2() {
        sleep(1)
        shell.click(Dimen.SCREEN_HEIGHT / 3)
        sleep(5)
        val isOpen = shell.isPage(0, page2)
        if (!isOpen) {
            backMain()
            return
        }
        sleep(35)
        backMain()
    }
}
