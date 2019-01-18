package com.yuan.helper.base

import java.io.InterruptedIOException
import java.lang.Exception

/**
 * Created by shucheng.qu on 2018/12/12
 */
interface IDownload {

    var name:String

    @Throws(InterruptedIOException::class,InterruptedException::class)
    fun down(upload: (String) -> Unit)

}