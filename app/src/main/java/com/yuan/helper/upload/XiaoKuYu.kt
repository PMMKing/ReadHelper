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
class XiaoKuYu : Upload() {
    override val main: String
        get() = ""
    override val name: String
        get() = "小酷鱼"
    override val launch: String
        get() = "com.renrenhui.kuyu/.ui.SplashActivity"
    override val packages: String
        get() = "com.renrenhui.kuyu"

    override fun launchSub() {
        shell.back()
        sleep(2)
    }

    override fun setDownLoad() {
        setTime(20 * 60)
        DownUtils.setDown(SPreference.get(DownUtils.XKY, 0))
    }

    override fun upload(title: String) {
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(10)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(93), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(63))
        sleep(15)
        shell.click(Dimen.dpToPx(42), Dimen.dpToPx(111))
        sleep(20)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(44), Dimen.dpToPx(53))
        sleep(50)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(46), Dimen.dpToPx(56))
        sleep(50)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.dpToPx(140))
        sleep(5)
        shell.input(title)
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 4 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(63))
        sleep(50)
    }

}