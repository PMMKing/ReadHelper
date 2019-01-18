package com.yuan.helper.base

import com.yuan.helper.utils.ShellHelper

/**
 * Created by shucheng.qu on 2018/12/10
 */
abstract class Upload : IUpload {

    protected var shell = ShellHelper.shell
    private var runTime = 3600000
    @Throws(InterruptedException::class)
    fun launchApp() {
        shell.startActivity(launch)
        sleep(20)
        launchSub()
    }

    @Throws(InterruptedException::class)
    fun killApp() {
        shell.stopApp(packages)
        sleep(10)
    }

    @Throws(InterruptedException::class)
    fun sleep(time: Long) {
        Thread.sleep((time * 1000))
    }

    override fun setTime(time: Int) {
        runTime = time * 1000
    }

    override fun getTime(): Int {
        return runTime
    }

}
