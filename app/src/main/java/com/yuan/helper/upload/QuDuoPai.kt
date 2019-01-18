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
class QuDuoPai : Upload() {
    override val main: String
        get() = ""
    override val name: String
        get() = "趣多拍"
    override val launch: String
        get() = "com.xike.yipai/.view.activity.StartActivity"
    override val packages: String
        get() = "com.xike.yipai"

    override fun launchSub() {
        setTime(40 * 60)
        shell.back()
        sleep(4)
    }

    override fun setDownLoad() {
        DownUtils.setDown(SPreference.get(DownUtils.QMXSP, 0))
    }

    override fun upload(title: String) {
        shell.click(Dimen.SCREEN_WIDTH / 6 * 5, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(10)
        shell.swipeY(Dimen.SCREEN_HEIGHT / 4 * 3, Dimen.SCREEN_HEIGHT / 4, 80)
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 6 * 5, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(117))
        sleep(20)
        shell.click(Dimen.SCREEN_WIDTH / 5, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(50))
        sleep(10)
        shell.click(Dimen.dpToPx(70), Dimen.dpToPx(126))
        sleep(30)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(56), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(22))
        sleep(30)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(133))
        sleep(5)
        shell.input(title)
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(40), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(30))
        sleep(20)
        shell.click(Dimen.SCREEN_WIDTH / 4 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(35))
        sleep(40)
    }

}