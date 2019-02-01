package com.yuan.helper.upload

import com.yuan.helper.MainApp
import com.yuan.helper.base.Upload
import com.yuan.helper.utils.Dimen
import com.yuan.helper.utils.DownUtils
import com.yuan.helper.utils.LogUtils
import com.yuan.helper.utils.ShellHelper
import java.io.File
import java.lang.Exception

/**
 * Created by shucheng.qu on 2018/12/10
 */
class HongYu : Upload() {

    override val main: String
        get() = ""
    override val name: String
        get() = "红域视频"
    override val launch: String
        get() = "com.hongyu.phonelive/.activity.LauncherActivity"
    override val packages: String
        get() = "com.hongyu.phonelive"

    override fun launchSub() {

    }

    override fun setDownLoad() {
        DownUtils.setDown()
    }

    override fun upload(title: String) {
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(7)
        shell.click(Dimen.SCREEN_WIDTH / 4 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(30))
        sleep(7)
        shell.click(Dimen.dpToPx(37), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(45))
        sleep(7)
        shell.click(Dimen.dpToPx(45), Dimen.dpToPx(110))
        sleep(50)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(53), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(43))
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(193))
        sleep(50)
        shell.click(Dimen.SCREEN_WIDTH / 3 * 2, Dimen.dpToPx(150))
        sleep(5)
        shell.input(title)
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.dpToPx(488))
        sleep(30)
        shell.rm("${ShellHelper.sdPath}/DCIM/yunbao")
        sleep(20)
    }

}