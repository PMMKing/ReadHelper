package com.yuan.helper.read

import com.yuan.helper.base.ReadApp
import com.yuan.helper.utils.Dimen

/**
 * Created by shucheng.qu on 2018/11/28
 */
class QiMaoApp : ReadApp() {
    override val page: String
        get() = "com.kmxs.reader/org.geometerplus.android.fbreader.FBReader"
    override val name: String
        get() = "七猫小说"
    override val launch: String
        get() = "com.kmxs.reader/.loading.ui.LoadingActivity"
    override val main: String
        get() = "com.kmxs.reader/.home.ui.HomeActivity"
    override val packages: String
        get() = "com.kmxs.reader"

    @Throws(InterruptedException::class)
    override fun launchSub() {
        setTime(3*60*60)
        shell.click(Dimen.SCREEN_WIDTH / 8 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(6)
        shell.click(Dimen.SCREEN_WIDTH / 2, Dimen.dpToPx(390))
        sleep(6)
        shell.click(Dimen.SCREEN_WIDTH / 4 * 3, Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20))
        sleep(6)
    }

    @Throws(InterruptedException::class)
    override fun read() {
        shell.swipeX(Dimen.SCREEN_WIDTH / 4 * 3, Dimen.SCREEN_WIDTH / 4, Dimen.SCREEN_HEIGHT / 4, Dimen.SCREEN_HEIGHT / 4 * 3)
        sleep(20)
    }
}
