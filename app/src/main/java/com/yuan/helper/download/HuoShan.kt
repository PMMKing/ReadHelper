package com.yuan.helper.download

import com.yuan.helper.base.Download
import com.yuan.helper.bean.huoshan.HuoShanListBean
import com.yuan.helper.net.Requests
import java.util.regex.Pattern

/**
 * Created by shucheng.qu on 2018/12/11
 */
class HuoShan : Download {

    override var name: String = "火山视频"
        get() = field
        set(value) {
            field = value
        }

    var url: String = "https://api.huoshan.com/hotsoon/feed/?type=find&tab_id=1714&channel_id=11152&sub_channel_id=1714&min_time=0&offset=0&count=10&req_from=feed_refresh&live_sdk_version=534&iid=55166716119&device_id=59432797713&ac=wifi&channel=nubiamm&aid=1112&app_name=live_stream&version_code=534&version_name=5.3.4&device_platform=android&ssmix=a&device_type=NX508J&device_brand=nubia&language=zh&os_api=22&os_version=5.1.1&uuid=A000004ED5C414&openudid=8d9774a541ed74ec&manifest_version_code=534&resolution=1080*1920&dpi=480&update_version_code=5340&_rticket=1545405623113&ab_version=391711%2C493891%2C646273%2C662548%2C654205%2C639554%2C661938%2C651060%2C641562%2C644423%2C637501%2C612163%2C654192%2C557631%2C651048%2C629147%2C633723%2C645522%2C637814%2C627201%2C657399%2C374106%2C657853%2C501248%2C344334%2C650205%2C662652%2C616789%2C505470%2C299908%2C632485%2C653276%2C586731%2C651646%2C598627%2C641184%2C457535%2C618719%2C596133%2C500930%2C526415&ab_group=526415&mcc_mnc=46011&ts=${(System.currentTimeMillis() / 1000).toInt()}"
        get() = field
        set(value) {
            field = value
        }

    private val header = HashMap<String, String>()

    constructor(tag: Int, name: String) {
        this.name = name
        when (tag) {
            1 -> {
                tagUrl(1714)
            }
            2 -> {
                tagUrl(1706)
            }
            3 -> {
                tagUrl(1703)
            }
        }
    }

    init {
        header["Connection"] = "keep-alive"
        header["sdk-version"] = "1"
        header["User-Agent"] = "com.ss.android.ugc.live/534 (Linux; U; Android 5.1.1; zh_CN; NX508J; Build/LMY47V; Cronet/58.0.2991.0)"
        header["Accept-Language"] = "zh-cn"
        header["Cookie"] = "odin_tt=3355627a4d31784b47517a4741555733c5dc2653af2564b7403a4ce77620b0a96f34893e99527653984d8df863d7cf4f;sid_tt=\"9a2994365f656b2cbaacb9007c3e8c16\";sid_guard=\"9a2994365f656b2cbaacb9007c3e8c16%7C1545405598%7C5184000%7CTue%2C+19-Feb-2019+15%3A19%3A58+GMT\";sessionid=\"9a2994365f656b2cbaacb9007c3e8c16\";install_id=55166716119;ttreq=1\$7f6bd8e863be07842224b892c9585e04f65f127e;\$Path=\"/\";\$Domain=\"snssdk.com\";uid_tt=\"17eee633efe28d61c5418c0efbd4ce09\";"
    }

    override fun down(upload: (String) -> Unit) {
        val huoShanListBean = Requests.get(header, url, HuoShanListBean::class.java)
        huoShanListBean?.data?.forEach {
            val title = it.data.title.replace("@", "").replace("火山", "").replace("官方", "").replace("小助手", "").trim()
            if (title.isEmpty() || it.type != 3 || it.data.stats.digg_count < 6000) {
                return
            }
            it.data.video?.url_list?.get(0)?.let { url ->
                Requests.getDown(url, upload = { upload(title) })
            }
        }
    }

    fun uuu(upp:(String,Int) -> Boolean){

    }

    private fun fff(){
        down {
            uuu { s, i ->
                return@uuu true
            }
        }
    }

    private fun tagUrl(tag: Int) {
        url = "https://api.huoshan.com/hotsoon/feed/?type=find&tab_id=$tag&channel_id=11152&sub_channel_id=$tag&min_time=0&offset=0&count=10&req_from=feed_refresh&live_sdk_version=534&iid=55166716119&device_id=59432797713&ac=wifi&channel=nubiamm&aid=1112&app_name=live_stream&version_code=534&version_name=5.3.4&device_platform=android&ssmix=a&device_type=NX508J&device_brand=nubia&language=zh&os_api=22&os_version=5.1.1&uuid=A000004ED5C414&openudid=8d9774a541ed74ec&manifest_version_code=534&resolution=1080*1920&dpi=480&update_version_code=5340&_rticket=1545405623113&ab_version=391711%2C493891%2C646273%2C662548%2C654205%2C639554%2C661938%2C651060%2C641562%2C644423%2C637501%2C612163%2C654192%2C557631%2C651048%2C629147%2C633723%2C645522%2C637814%2C627201%2C657399%2C374106%2C657853%2C501248%2C344334%2C650205%2C662652%2C616789%2C505470%2C299908%2C632485%2C653276%2C586731%2C651646%2C598627%2C641184%2C457535%2C618719%2C596133%2C500930%2C526415&ab_group=526415&mcc_mnc=46011&ts=${(System.currentTimeMillis() / 1000).toInt()}"
    }

}