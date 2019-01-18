package com.yuan.helper.upload

import com.yuan.helper.MainApp
import com.yuan.helper.base.Upload
import com.yuan.helper.download.QuanMinDSP
import com.yuan.helper.utils.Dimen
import com.yuan.helper.utils.DownUtils
import com.yuan.helper.utils.SPreference

/**
 * Created by shucheng.qu on 2018/12/10
 */
class BoBo : Upload() {
    override val main: String
        get() = ""
    override val name: String
        get() = "波波视频"
    override val launch: String
        get() = "tv.yixia.bobo/com.kg.v1.welcome.WelcomeActivity"
    override val packages: String
        get() = "tv.yixia.bobo"

    override fun launchSub() {
    }

    override fun setDownLoad() {
        DownUtils.setDown(SPreference.get(DownUtils.QMXSP, 0))
    }

    override fun upload(title: String) {
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 4 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(116))
        sleep(10)
        shell.click(Dimen.dpToPx(42), Dimen.dpToPx(112))
        sleep(20)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(48), Dimen.dpToPx(40))
        sleep(20)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(48), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(51))
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 3 * 2, Dimen.dpToPx(150))
        sleep(5)
        shell.input(title)
        sleep(50)
        shell.click(Dimen.SCREEN_WIDTH/4*3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(34))
        sleep(15)
    }

}