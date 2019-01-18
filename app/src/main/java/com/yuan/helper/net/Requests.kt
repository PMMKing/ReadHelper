package com.yuan.helper.net

import android.annotation.SuppressLint
import android.util.Log
import com.alibaba.fastjson.JSON
import com.yuan.helper.utils.FFmpegUtils
import com.yuan.helper.utils.LogUtils
import com.yuan.helper.utils.ShellHelper
import okhttp3.Headers
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import okhttp3.FormBody
import java.lang.Exception
import java.util.*


/**
 * Created by shucheng.qu on 2018/12/10
 */
object Requests {

    fun get(header: HashMap<String, String> = HashMap(), url: String): Response? {
        val get = Request.Builder().url(url).get()
        header.forEach { (k, v) ->
            get.addHeader(k, v)
        }
        val request = get.build()
        return OkHttp.client.newCall(request).execute()
    }

    fun <T> get(header: HashMap<String, String> = HashMap(), url: String, clazz: Class<T>): T? {
        val response = get(header, url)
        return JSON.parseObject(response?.body()?.string(), clazz)
    }

    fun postFrom(url: String, param: HashMap<String, String> = HashMap(), header: HashMap<String, String> = HashMap()): Response? {
        val builder = FormBody.Builder()
        param.forEach { (k, v) ->
            builder.add(k, v)
        }
        val formBody = builder.build()
        val post = Request.Builder().url(url).post(formBody)
        header.forEach { (k, v) ->
            post.addHeader(k, v)
        }
        val request = post.build()
        return OkHttp.client.newCall(request).execute()
    }

    fun <T> postFrom(url: String, param: HashMap<String, String> = HashMap(), header: HashMap<String, String> = HashMap(), clazz: Class<T>): T? {
        val response = postFrom(url, param, header)
        return JSON.parseObject(response?.body()?.string(), clazz)
    }


    @SuppressLint("SdCardPath")
    fun getDown(url: String, header: HashMap<String, String> = HashMap(), upload: () -> Unit) {
        val response = get(header, url)
        val bytes = response?.body()?.bytes()
        val fileOutputStream = FileOutputStream(File("/mnt/sdcard/DCIM/aaaa.mp4"))
        fileOutputStream.write(bytes)
        fileOutputStream.write(Random().nextInt(9999999).toString().toByteArray())
        fileOutputStream.flush()
        fileOutputStream.close()
//        FFmpegUtils.zipMp4()
        bytes?.let {
            if (bytes.size > 100) {
                upload()
            }
        }
    }

}
