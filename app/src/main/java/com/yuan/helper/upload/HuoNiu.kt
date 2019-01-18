package com.yuan.helper.upload

import com.yuan.helper.base.Upload
import com.yuan.helper.utils.Dimen
import com.yuan.helper.utils.DownUtils

/**
 * Created by shucheng.qu on 2018/12/10
 */
class HuoNiu : Upload() {
    override val main: String
        get() = ""
    override val name: String
        get() = "火牛视频"
    override val launch: String
        get() = "com.waqu.android.firebull/.ui.LaunchActivity"
    override val packages: String
        get() = "com.waqu.android.firebull"

    override fun launchSub() {

    }

    override fun setDownLoad() {
        DownUtils.setDown()
    }

    override fun upload(title: String) {
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 8 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(55))
        sleep(15)
        shell.click(Dimen.SCREEN_WIDTH / 6, Dimen.dpToPx(133))
        sleep(40)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(43), Dimen.dpToPx(55))
        sleep(60)
        shell.click(Dimen.SCREEN_WIDTH /2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(75))
        sleep(5)
        shell.input(title)
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH/4*3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(35))
        sleep(50)
    }

}