package com.yuan.helper.window

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.TextView
import com.cheng.rvadapter.holder.BaseViewHolder
import com.yuan.helper.base.IApp
import com.yuan.helper.base.ReadApp

/**
 * Created by shucheng.qu on 2018/11/24
 */
class AppViewHolder(context: Context?, itemView: View?) : BaseViewHolder<IApp>(context, itemView) {

    var tvApp: TextView? = null

    init {
        tvApp = itemView as TextView
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: BaseViewHolder<*>?, p1: IApp?, p2: Int) {
        if (p1 is ReadApp) {
            tvApp?.text = "读-${p1.name}"
        } else {
            tvApp?.text = "传-${p1?.name}"
        }
    }


}