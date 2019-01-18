package com.yuan.helper.base

/**
 * Created by shucheng.qu on 2018/12/8
 */
interface IRead :IApp{

    val page: String

    @Throws(InterruptedException::class)
    fun launchSub()

    @Throws(InterruptedException::class)
    fun read()

    fun setTime(time: Int)

    fun getTime(): Int

}

interface IRead2 :IApp{

    val page2: String

    @Throws(InterruptedException::class)
    fun launch2Sub()

    @Throws(InterruptedException::class)
    fun read2()

    fun setTime2(time: Int)

    fun getTime2(): Int

}
