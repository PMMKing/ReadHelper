package com.yuan.helper.window

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.util.AttributeSet
import android.view.*
import android.widget.FrameLayout

import com.yuan.helper.utils.Dimen
import com.yuan.helper.utils.ThreadHelper

import android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
import android.view.WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
import androidx.recyclerview.widget.LinearLayoutManager
import com.cheng.rvadapter.adapter.MultiAdapter
import com.cheng.rvadapter.holder.BaseViewHolder
import com.cheng.rvadapter.manage.ITypeView
import com.yuan.helper.R
import com.yuan.helper.base.IApp
import com.yuan.helper.read.*
import com.yuan.helper.upload.*
import com.yuan.helper.utils.LogUtils
import com.yuan.helper.utils.ShellHelper
import kotlinx.android.synthetic.main.helper_layout.view.*
import kotlin.concurrent.thread

/**
 * Created by shucheng.qu on 2018/11/12
 */
class HelperView : FrameLayout {

    private var windowManager: WindowManager? = null
    private var layoutParams: WindowManager.LayoutParams? = null
    private var downY = 0f
    private var downX = 0f
    private val apps = arrayListOf<IApp>()
    private var selectAdapter: MultiAdapter<IApp>? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        FrameLayout.inflate(getContext(), R.layout.helper_layout, this)
        initData()
        initWindow()
        initView()
    }

    private fun initData() {
        apps.add(JingxuanTTApp())
        apps.add(Quanminxsp())

        apps.add(JinRiTTApp())
        apps.add(QuttApp())
        apps.add(SanYanApp())
        apps.add(BaoShiXQApp())
        apps.add(TaoXinWenApp())
        apps.add(ZhongQingKDApp())
        apps.add(QuduopaiApp())
        apps.add(QiMaoApp())
        apps.add(SouhuZXApp())
        apps.add(TaoXiaoShuoApp())


//        apps.add(QuDuoPai())
//        apps.add(HuiToutAPP())
//        apps.add(QuanminXSPApp())
//        apps.add(HuoShan())
//        apps.add(BoBo())
//        apps.add(PiPiXia())
//        apps.add(XiaoKuYu())
//        apps.add(BaoMiHua())
//        apps.add(HongYu())
//        apps.add(HuoNiuApp())
//        apps.add(HuoNiu())
//        apps.add(DongfangTTApp())
//        apps.add(HaicaoGSApp())
//        apps.add(YiKeApp())
//        apps.add(XiankanDApp())
//        apps.add(XinTouTApp())
//        apps.add(HaHaApp())
    }

    private fun initWindow() {
        // 获取WindowManager服务
        windowManager = context.getSystemService(Service.WINDOW_SERVICE) as WindowManager
        // 设置LayoutParam
        layoutParams = WindowManager.LayoutParams(-1, -1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layoutParams?.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            layoutParams?.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
        }
        layoutParams?.flags = FLAG_NOT_FOCUSABLE or FLAG_WATCH_OUTSIDE_TOUCH
        layoutParams?.format = PixelFormat.RGBA_8888
        layoutParams?.width = Dimen.dpToPx(60)
        layoutParams?.height = Dimen.dpToPx(100)
        layoutParams?.y = Dimen.SCREEN_HEIGHT / 4
        layoutParams?.x = 0
        layoutParams?.gravity = Gravity.LEFT
        windowManager?.addView(this, layoutParams)
    }

    private fun initView() {
        val selectParams = FrameLayout.LayoutParams(Dimen.SCREEN_WIDTH / 2, -1)
        rv_selector.layoutParams = selectParams
        val appParams = FrameLayout.LayoutParams(Dimen.SCREEN_WIDTH / 2, -1)
        appParams.leftMargin = Dimen.SCREEN_WIDTH / 2
        rv_apps.layoutParams = appParams

        val appAdapter = MultiAdapter<IApp>(context, apps).addTypeView(object : ITypeView<IApp> {
            override fun isForViewType(p0: IApp?, p1: Int): Boolean {
                return true
            }

            override fun createViewHolder(p0: Context?, p1: ViewGroup?): BaseViewHolder<*> {
                return AppViewHolder(p0, LayoutInflater.from(p0).inflate(R.layout.pub_app_item_layout, p1, false))
            }

        })
        appAdapter.setOnItemClickListener { _, any, _ ->
            val app = any as IApp
            selectAdapter?.addData(app)
            selectAdapter?.notifyDataSetChanged()
        }
        rv_apps.adapter = appAdapter
        rv_apps.layoutManager = LinearLayoutManager(context)
        rv_apps.setHasFixedSize(true)


        selectAdapter = MultiAdapter<IApp>(context).addTypeView(object : ITypeView<IApp> {
            override fun isForViewType(p0: IApp?, p1: Int): Boolean {
                return true
            }

            override fun createViewHolder(p0: Context?, p1: ViewGroup?): BaseViewHolder<*> {
                return AppViewHolder(p0, LayoutInflater.from(p0).inflate(R.layout.pub_app_item_layout, p1, false))
            }
        })

        rv_selector.adapter = selectAdapter
        rv_selector.layoutManager = LinearLayoutManager(context)
        rv_selector.setHasFixedSize(true)


        tv_auto.setOnClickListener {
            svGone()
            ThreadHelper.threadHelper.addApp(*selectAdapter!!.data!!.toTypedArray())
        }
        tv_select.setOnClickListener {
            if (rv_apps.visibility == GONE) {
                rv_apps.visibility = VISIBLE
                rv_selector.visibility = VISIBLE
                layoutParams?.width = Dimen.SCREEN_WIDTH
                layoutParams?.height = Dimen.SCREEN_HEIGHT - Dimen.dpToPx(20)
                windowManager?.updateViewLayout(this@HelperView, layoutParams)
            } else {
                svGone()
            }
        }

        tv_end.setOnClickListener {
            selectAdapter?.data = arrayListOf()
            ThreadHelper.threadHelper.stopApp()
        }
    }

    private fun svGone() {
        rv_apps.visibility = View.GONE
        rv_selector.visibility = View.GONE
        layoutParams?.width = Dimen.dpToPx(60)
        layoutParams?.height = Dimen.dpToPx(100)
        windowManager?.updateViewLayout(this@HelperView, layoutParams)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.rawX
                downY = event.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                val diffX = Math.abs(event.rawX - downX)
                val diffY = Math.abs(event.rawY - downY)
                if (diffY > 20 && diffX > 20 && rv_apps.visibility == View.GONE)
                    return true
            }
        }
        return super.onInterceptTouchEvent(event)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downY = event.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                layoutParams!!.y += (event.rawY - downY).toInt()
                layoutParams!!.x = (event.rawX).toInt()
                windowManager!!.updateViewLayout(this, layoutParams)
                downY = event.rawY
            }
        }
        return true
    }

}
