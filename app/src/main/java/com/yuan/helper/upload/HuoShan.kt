package com.yuan.helper.upload

import com.yuan.helper.base.Upload
import com.yuan.helper.utils.Dimen
import com.yuan.helper.utils.DownUtils
import com.yuan.helper.utils.SPreference
import com.yuan.helper.utils.ShellHelper

/**
 * Created by shucheng.qu on 2018/12/10
 */
class HuoShan : Upload() {
    override val main: String
        get() = ""
    override val name: String
        get() = "火山小视频"
    override val launch: String
        get() = "com.ss.android.ugc.live/.main.MainActivity"
    override val packages: String
        get() = "com.ss.android.ugc.live"

    override fun launchSub() {
    }

    override fun setDownLoad() {
        DownUtils.setDown(SPreference.get(DownUtils.HSXSP, 3))
        setTime(25 * 60)
    }

    override fun upload(title: String) {
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(5)
        shell.click((Dimen.SCREEN_WIDTH * 0.16667).toInt(), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 6, Dimen.dpToPx(104))
        sleep(20)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(43), Dimen.dpToPx(23))
        sleep(50)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(82), Dimen.SCREEN_HEIGHT - Dimen.dpToPx(55))
        sleep(10)
        shell.click(Dimen.SCREEN_WIDTH / 3 * 2, Dimen.dpToPx(120))
        sleep(5)
        shell.input(title)
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(98))
        sleep(50)
        shell.rm("${ShellHelper.sdPath}/DCIM/Camera")
    }

}