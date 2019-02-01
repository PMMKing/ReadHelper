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
class Quanminxsp : Upload() {
    override val main: String
        get() = ""
    override val name: String
        get() = "全民小视频"
    override val launch: String
        get() = "com.baidu.minivideo/.app.activity.splash.SplashActivity"
    override val packages: String
        get() = "com.baidu.minivideo"

    override fun launchSub() {
    }

    override fun setDownLoad() {
        DownUtils.setDown(SPreference.get(DownUtils.QMXSP,0))
    }

    override fun upload(title: String) {
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(20)
        shell.click(Dimen.SCREEN_WIDTH / 2 + Dimen.dpToPx(115), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(55))
        sleep(15)
        shell.click((Dimen.SCREEN_WIDTH * 0.11296).toInt(), (Dimen.SCREEN_HEIGHT * 0.25677).toInt())
        sleep(40)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(28), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(30))
        sleep(20)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(100), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(60))
        sleep(15)
        shell.click(Dimen.dpToPx(100), Dimen.dpToPx(130))
        sleep(5)
        shell.input(title)
        sleep(50)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(150), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(66))
        sleep(15)
    }

}