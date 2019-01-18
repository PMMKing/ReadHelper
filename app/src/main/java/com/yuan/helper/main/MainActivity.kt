package com.yuan.helper.main

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.fastjson.JSON
import com.cheng.rvadapter.adapter.MultiAdapter
import com.cheng.rvadapter.holder.BaseViewHolder
import com.cheng.rvadapter.manage.ITypeView
import com.yuan.helper.HelperService
import com.yuan.helper.MainApp
import com.yuan.helper.R
import com.yuan.helper.base.BaseActivity
import com.yuan.helper.base.Download
import com.yuan.helper.download.Douyin
import com.yuan.helper.download.HuoShan
import com.yuan.helper.download.QuanMinDSP
import com.yuan.helper.utils.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : BaseActivity() {

    var key = DownUtils.QMXSP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_start.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this@MainActivity)) {
                    try {
                        startActivityForResult(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName")), 0)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                } else {
                    startService(Intent(this@MainActivity, HelperService::class.java))
                }
            } else {
                startService(Intent(this@MainActivity, HelperService::class.java))
            }
        }

        refreshText()
        val hasWriteStoragePermission = ContextCompat.checkSelfPermission(application, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
        }

        tv_test.setOnClickListener {
            thread {
//                FFmpegUtils.zipMp4()
            }
        }

        tv_sougou.setOnClickListener {
            ShellHelper.shell.sogou()
        }

        tv_quanminxsp.setOnClickListener {
            ToastUtils.showToast("设置全民小视频下载器")
            key = DownUtils.QMXSP
        }

        tv_huoshanxsp.setOnClickListener {
            ToastUtils.showToast("设置火山视频下载器")
            key = DownUtils.HSXSP
        }

        tv_pipixia.setOnClickListener {
            ToastUtils.showToast("设置皮皮虾下载器")
            key = DownUtils.PPX
        }
        tv_xiaokuyu.setOnClickListener {
            ToastUtils.showToast("设置皮皮虾下载器")
            key = DownUtils.XKY
        }
        tv_baomihua.setOnClickListener {
            ToastUtils.showToast("设置爆米花下载器")
            key = DownUtils.BMH
        }
        initView()
        refreshText()
    }

    private fun initView() {
        val adapter = MultiAdapter<Download>(this, DownUtils.downList).addTypeView(object : ITypeView<Download> {
            override fun isForViewType(p0: Download?, p1: Int): Boolean {
                return true
            }

            override fun createViewHolder(p0: Context?, p1: ViewGroup?): BaseViewHolder<*> {
                return MainHolder(p0, LayoutInflater.from(p0).inflate(R.layout.main_item_holder_layout, p1, false))
            }
        })
        rv_list.adapter = adapter
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.setHasFixedSize(true)
        adapter.setOnItemClickListener { view, any, i ->
            ToastUtils.showToast((any as Download).name)
            SPreference.put(key, i)
            refreshText()
        }
    }

    private fun refreshText() {
        tv_quanminxsp.text = getTextSpan("全民小视频", DownUtils.getIndexName(SPreference.get(DownUtils.QMXSP, 0)))
        tv_huoshanxsp.text = getTextSpan("火山小视频", DownUtils.getIndexName(SPreference.get(DownUtils.HSXSP, 0)))
        tv_pipixia.text = getTextSpan("皮皮虾", DownUtils.getIndexName(SPreference.get(DownUtils.PPX, 0)))
        tv_xiaokuyu.text = getTextSpan("小酷鱼", DownUtils.getIndexName(SPreference.get(DownUtils.XKY, 0)))
        tv_baomihua.text = getTextSpan("爆米花", DownUtils.getIndexName(SPreference.get(DownUtils.BMH, 0)))
    }

    private fun getTextSpan(name: String, from: String = ""): SpannableString {
        val content = name + from
        val ss = SpannableString(content)
        ss.setSpan(RelativeSizeSpan(0.6f), name.length, content.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        return ss
    }

}
