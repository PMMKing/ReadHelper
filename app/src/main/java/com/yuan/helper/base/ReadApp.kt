package com.yuan.helper.base

import com.yuan.helper.utils.Dimen
import com.yuan.helper.utils.ShellHelper

/**
 * Created by shucheng.qu on 2018/11/24
 */
abstract class ReadApp : IRead {

    protected var shell = ShellHelper.shell

    private var runTime = 4000000

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

    override fun setTime(time: Int) {
        runTime = time * 1000
    }

    override fun getTime(): Int {
        return runTime
    }

    @Throws(InterruptedException::class)
    protected fun backMain() {
        shell.backPage(main, main)
        shell.swipeY(Dimen.SCREEN_HEIGHT / 3 * 2, Dimen.SCREEN_HEIGHT / 3)
        sleep(2)
    }

    @Throws(InterruptedException::class)
    fun sleep(time: Long) {
        Thread.sleep((time * 1000))
    }

}

abstract class ReadApp2 : ReadApp(), IRead2 {

    private var runTime2 = 4500000

    fun launch2App() {
        shell.startActivity(launch)
        sleep(20)
        launch2Sub()
    }

    override fun setTime2(time: Int) {
        runTime2 = time * 1000
    }

    override fun getTime2(): Int {
        return runTime2
    }

}
