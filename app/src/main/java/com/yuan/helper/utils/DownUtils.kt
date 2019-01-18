package com.yuan.helper.utils

import com.yuan.helper.MainApp
import com.yuan.helper.base.Download
import com.yuan.helper.download.Douyin
import com.yuan.helper.download.HuoShan
import com.yuan.helper.download.QuanMinDSP

/**
 * Created by shucheng.qu on 2018/12/22
 */
object DownUtils {

    val QMXSP = "qmxsp"
    val PPX = "pipixia"
    val HSXSP = "huoshanxsp"
    val XKY = "xiaokuyu"
    val BMH = "baomihua"

    val downList = arrayListOf(HuoShan(1, "火山搞笑"), HuoShan(2, "火山三农"), HuoShan(3, "火山美食"), QuanMinDSP("25", "全民美女"), QuanMinDSP("27", "全民搞笑"), Douyin())

    fun setDown(index: Int = 0) {
        MainApp.download = downList[index]
    }

    fun getIndexName(index: Int = 0): String {
        return downList[index].name
    }

}