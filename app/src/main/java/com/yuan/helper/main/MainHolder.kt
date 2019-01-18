package com.yuan.helper.main

import android.content.Context
import android.view.View
import android.widget.TextView
import com.cheng.rvadapter.holder.BaseViewHolder
import com.yuan.helper.base.Download

/**
 * Created by shucheng.qu on 2018/12/22
 */
class MainHolder(context: Context?, itemView: View?) : BaseViewHolder<Download>(context, itemView) {

    var tvItem:TextView? = null

    init {
        tvItem = itemView as TextView
    }

    override fun onBindViewHolder(p0: BaseViewHolder<*>?, p1: Download?, p2: Int) {
        tvItem?.text = p1?.name
    }

}