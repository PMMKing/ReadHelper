package com.yuan.helper.utils

import android.os.Looper
import com.yuan.helper.MainApp
import com.yuan.helper.base.IApp
import com.yuan.helper.base.ReadApp
import com.yuan.helper.base.ReadApp2
import com.yuan.helper.base.Upload
import com.yuan.helper.download.Douyin
import java.io.InterruptedIOException

import java.util.ArrayList
import java.util.Arrays
import kotlin.concurrent.thread

/**
 * Created by shucheng.qu on 2018/11/24
 */
class ThreadHelper private constructor() {
    private val autoThread: AutoThread

    init {
        autoThread = AutoThread()
        autoThread.start()
//        thread {
//            while (true) {
//                Thread.sleep(30000)
//                if (autoThread.state != Thread.State.TIMED_WAITING) {
//                    LogUtils.logd("线程故障，正在尝试重启线程Run")
//                    Thread.sleep(2000)
//                    if (autoThread.state != Thread.State.TIMED_WAITING) {
//                        Thread.sleep(2000)
//                        if (autoThread.state != Thread.State.TIMED_WAITING) {
//                            try {
//                                autoThread.run()
//                            } catch (e: Exception) {
//                                e.printStackTrace()
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }

    fun addApp(vararg app: IApp) {
        autoThread.addApp(*app)
//        thread {
//            if (autoThread.state != Thread.State.TIMED_WAITING) {
//                LogUtils.logd("线程故障，正在尝试重启线程Run")
//                Thread.sleep(2000)
//                if (autoThread.state != Thread.State.TIMED_WAITING) {
//                    Thread.sleep(2000)
//                    if (autoThread.state != Thread.State.TIMED_WAITING) {
//                        try {
//                            autoThread.run()
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                        }
//                    }
//                }
//            }
//        }
    }

    fun stopApp() {
        autoThread.removeApp()
    }

    private inner class AutoThread : Thread() {

        private val apps = ArrayList<IApp>()

        override fun run() {
            while (true) {
                try {
                    sleep(10000)
                    apps.forEach {
                        if (it is ReadApp) {
                            it.killApp()
                            it.launchApp()
                            val oldTime = System.currentTimeMillis()
                            while (System.currentTimeMillis() - oldTime < it.getTime()) {
                                it.read()
                            }
                            it.killApp()
                            if (it is ReadApp2) {
                                it.launch2App()
                                val oldTime2 = System.currentTimeMillis()
                                while (System.currentTimeMillis() - oldTime2 < it.getTime2()) {
                                    it.read2()
                                }
                                it.killApp()
                            }
                        }
                        if (it is Upload) {
                            it.setDownLoad()
                            ShellHelper.shell.adbkeyboard()
                            val oldTime = System.currentTimeMillis()
                            while (System.currentTimeMillis() - oldTime < it.getTime()) {
                                MainApp.download.down { title ->
                                    LogUtils.logd("下载器 : ${MainApp.download.name}")
                                    LogUtils.logd("title : $title")
                                    it.killApp()
                                    it.launchApp()
                                    ShellHelper.shell.refresh()
                                    it.upload(title)
                                    it.killApp()

                                }
                            }
                        }
                    }
                    LogUtils.logd("线程run")
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                    LogUtils.logd(e.toString())
                    LogUtils.logd("停止自动阅读")
                    LogUtils.logd(apps.size.toString())
                    ShellHelper.shell.sogou()
                    try {
                        Thread.sleep(2000)
                    } catch (e1: InterruptedException) {
                        e1.printStackTrace()
                    }
                } catch (e: NullPointerException) {
                    e.printStackTrace()
                    LogUtils.logd(e.toString())
                } catch (e: IndexOutOfBoundsException) {
                    e.printStackTrace()
                    LogUtils.logd(e.toString())
                } catch (e: InterruptedIOException) {
                    e.printStackTrace()
                    LogUtils.logd(e.toString())
                    LogUtils.logd(apps.size.toString())
                } catch (e: Exception) {
                    e.printStackTrace()
                    LogUtils.logd(e.toString())
                }
            }
        }

        fun addApp(vararg apps: IApp) {
            interrupt()
            this.apps.clear()
            this.apps.addAll(Arrays.asList(*apps))
        }

        fun removeApp() {
            interrupt()
            apps.clear()
        }

    }

    companion object {
        val threadHelper = ThreadHelper()
    }


}
