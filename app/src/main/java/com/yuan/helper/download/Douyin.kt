package com.yuan.helper.download

import com.yuan.helper.base.Download
import com.yuan.helper.bean.douyin.DouyinListBean
import com.yuan.helper.net.Requests
import java.util.regex.Pattern

/**
 * Created by shucheng.qu on 2018/12/11
 */
class Douyin : Download() {
    override var name: String = "抖音All"
        get() = field
        set(value) {}

    var url: String = "https://aweme-eagle.snssdk.com/aweme/v1/feed/?version_code=3.4.0&pass-region=1&pass-route=1&js_sdk_version=1.3.0.1&app_name=aweme&vid=A7FCE49E-2B95-4CD8-88E2-06B1EFBC4D5E&app_version=3.4.0&device_id=57300219212&channel=App%20Store&aid=1128&screen_width=1242&openudid=34b191ae7037612aaea09c4055e59aaa0cdf85c5&os_api=18&ac=4G&os_version=12.1&device_platform=iphone&build_number=34008&iid=52758939432&device_type=iPhone9,2&idfa=557499F1-0018-41C0-83ED-DB523AF89315&volume=0.32&min_cursor=0&feed_style=0&filter_warn=0&count=6&pull_type=0&type=0&max_cursor=0&mas=011e277eecf2642dcfea13efe4121a40c82fe672c45f5427bee0c7&as=a1f53330c17c6cafe23374&ts=1543651265"
        get() = field
        set(value) {}

    private val header = HashMap<String, String>()
    private val vheader = HashMap<String, String>()

    init {
        header["Connection"] = "keep-alive"
        header["sdk-version"] = "1"
        header["User-Agent"] = "Aweme 3.4.0 rv:34008 (iPhone; iOS 12.1; zh_CN) Cronet"
        header["X-SS-TC"] = "0"
        header["Accept-Language"] = "zh-cn"
        header["Cookie"] = "odin_tt=632f829d45776e089b261f6592b53d46d933a65654a9e6b685546008dc076bc6ae4ffde00540c9beac8bc623ba293a9f; install_id=52758939432; ttreq=1\$b03dfe5f1a55e1ece4ee2cffa4678c2e949d5721"

        vheader["Connection"] = "keep-alive"
        vheader["Range"] = "bytes=819200-"
        vheader["Accept"] = "*/*"
        vheader["Accept-Encoding"] = "gzip, deflate"
        vheader["User-Agent"] = "Aweme/34008 CFNetwork/975.0.3 Darwin/18.2.0"
        vheader["Accept-Language"] = "zh-cn"
    }

    override fun down(upload: (String) -> Unit) {
        val douyinList = Requests.get(header, url, DouyinListBean::class.java)
        douyinList?.aweme_list?.forEach {
            var title = it.desc.replace("@", "").replace("抖音小助手", "").replace("/", "").replace("抖音", "").replace("#", "").trim()
            val emoji = Pattern.compile("^[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]|[\\u2600-\\u27ff]+$", Pattern.UNICODE_CASE or Pattern.CASE_INSENSITIVE)
            val emojiMatcher = emoji.matcher(title)
            title = emojiMatcher.replaceAll("")
            if (title.length < 1 || it.is_ads) {
                return
            }
            val vdurl = it.video.download_addr.url_list[0].replace(" ", "%20").replace("&watermark=1", "").replace("&logo_name=aweme", "&version_code=3.4.0&pass-region=1&pass-route=1&js_sdk_version=1.3.0.1&app_name=aweme&vid=A7FCE49E-2B95-4CD8-88E2-06B1EFBC4D5E&app_version=3.4.0&device_id=57300219212&channel=App Store&aid=1128&screen_width=1242&openudid=34b191ae7037612aaea09c4055e59aaa0cdf85c5&os_api=18&ac=WIFI&os_version=12.1&device_platform=iphone&build_number=34008&iid=52758939432&device_type=iPhone9,2&idfa=557499F1-0018-41C0-83ED-DB523AF89315")
            val response = Requests.get(vheader, vdurl)
            val dlurl = response?.priorResponse()?.header("Location")
            dlurl?.let { url ->
                Requests.getDown(url, upload = { upload(title) })
            }
        }
    }

}