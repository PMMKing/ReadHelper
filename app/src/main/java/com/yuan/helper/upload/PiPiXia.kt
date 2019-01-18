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
class PiPiXia : Upload() {
    override val main: String
        get() = ""
    override val name: String
        get() = "皮皮虾"
    override val launch: String
        get() = "com.sup.android.superb/.SplashActivity"
    override val packages: String
        get() = "com.sup.android.superb"

    override fun launchSub() {
    }

    override fun setDownLoad() {
        DownUtils.setDown(SPreference.get(DownUtils.PPX, 0))
        setTime(20*60)
    }

    override fun upload(title: String) {
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(5)
        shell.click(Dimen.dpToPx(75), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(240))
        sleep(20)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(50), Dimen.dpToPx(30))
        sleep(10)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.dpToPx(100))
        sleep(5)
        shell.input(title)
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(60), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(30))
        sleep(40)
    }

}