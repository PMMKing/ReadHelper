package com.yuan.helper.read

import android.os.Build
import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen
import java.util.*

/**
 * Created by shucheng.qu on 2018/11/24
 */
class ZhongQingKDApp : ReadApp() {
    override val name: String
        get() = "中青看点"
    override val launch: String
        get() = "cn.youth.news/com.weishang.wxrd.activity.SplashActivity"
    override val main: String
        get() = "cn.youth.news/com.weishang.wxrd.activity.MainActivity"
    override val packages: String
        get() = "cn.youth.news"
    override val page: String
        get() = "cn.youth.news/com.weishang.wxrd.activity.WebViewActivity"

    override fun launchSub() {
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
        for (index in 0..20) {
            shell.swipeY(Dimen.SCREEN_HEIGHT / 3 * 2, Dimen.SCREEN_HEIGHT / 3, 100)
            sleep(3)
        }
        backMain()
    }

}
