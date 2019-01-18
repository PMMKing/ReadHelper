package com.yuan.helper.base

/**
 * Created by shucheng.qu on 2018/12/10
 */
interface IUpload : IApp {

    @Throws(InterruptedException::class)
    fun launchSub()

    @Throws(InterruptedException::class)
    fun setDownLoad()

    @Throws(InterruptedException::class)
    fun upload(title: String)

    fun setTime(time: Int)

    fun getTime(): Int

}