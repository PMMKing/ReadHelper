package com.yuan.helper.upload

import com.yuan.helper.base.Upload
import com.yuan.helper.utils.Dimen
import com.yuan.helper.utils.DownUtils
import com.yuan.helper.utils.LogUtils
import com.yuan.helper.utils.SPreference

/**
 * Created by shucheng.qu on 2018/12/10
 */
class BaoMiHua : Upload() {
    override val main: String
        get() = ""
    override val name: String
        get() = "爆米花"
    override val launch: String
        get() = "com.com.baomihuawang.androidclient/.ui.activity.SplashActivity"
    override val packages: String
        get() = "com.com.baomihuawang.androidclient"

    override fun launchSub() {

    }

    override fun setDownLoad() {
        DownUtils.setDown(SPreference.get(DownUtils.BMH, 0))
    }

    override fun upload(title: String) {
        shell.click(Dimen.SCREEN_WIDTH / 10 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH - Dimen.dpToPx(29), Dimen.dpToPx(46))
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(10)
        shell.click(Dimen.SCREEN_WIDTH / 6, Dimen.dpToPx(150))
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(10)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.dpToPx(436))
        sleep(5)
        val temp = title.replace("[^\\u0000-\\uFFFF]", "").replace( "[\\pP\\p{Punct}]" , "")
        LogUtils.logd(temp)
        shell.input(temp)
        sleep(5)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.dpToPx(543))
        sleep(50)
    }

}