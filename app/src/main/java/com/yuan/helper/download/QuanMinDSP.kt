package com.yuan.helper.download

import com.yuan.helper.base.Download
import com.yuan.helper.bean.douyin.DouyinListBean
import com.yuan.helper.bean.quanminduanshipin.QMDSPListBean
import com.yuan.helper.net.Requests
import com.yuan.helper.utils.LogUtils
import java.util.regex.Pattern

/**
 * Created by shucheng.qu on 2018/12/11
 */
class QuanMinDSP() : Download() {
    override var name: String = "全民短视频"
        get() = field
        set(value) {
            field = value
        }

    var url: String = "http://app2.quanminzb.com/video/video/videoList"
        get() = field
        set(value) {
            field = value
        }

    private val header = HashMap<String, String>()

    private var type = "25"

    constructor(type: String,name:String) : this() {
        this.type = type
        this.name = name
    }

    constructor(type: String) : this() {
        this.type = type
    }

    init {
        header["Connection"] = "keep-alive"
        header["clientType"] = "2"
        header["version"] = "2.0.2"
        header["selfUserId"] = "5006867"
        header["appName"] = "shortVideo"
        header["cnid"] = "qmdsp05"
        header["Content-Type"] = "application/x-www-form-urlencoded"
        header["Authorization"] = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI2NzdjNjc2Zi0xNzIxLTRkYWYtODE5NC01NzM0MWRhM2U1YWIiLCJzdWIiOiI1MDA2ODY3IiwiZXhwIjoxNTQ3NDgzOTk4fQ.e9EnDnn8v3RnfY-ovv3tjJ5hWBSETym8JaefW5__rxze_EJjRTIIsaEVHglBmXT63LhJnJ-V4v4kp-IhdbwR6Q"
    }

    override fun down(upload: (String) -> Unit) {
        val param = HashMap<String, String>()
        param["tagId"] = type
        param["videoType"] = "1"
        param["pageNum"] = "1"
        param["pageSize"] = "20"
        param["time"] = (System.currentTimeMillis() / 1000).toInt().toString()
        val qmdspList = Requests.postFrom(url, param, header, QMDSPListBean::class.java)
        qmdspList?.data?.list?.forEach {
            val title = it.introduction.replace("#", "").trim()
            if (title.length < 1) {
                return
            }
            it.fileName?.let { url ->
                Requests.getDown(url, upload = { upload(title) })
            }
        }
    }

}