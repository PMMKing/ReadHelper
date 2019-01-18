package com.yuan.helper.utils

import android.widget.Toast
import com.yuan.helper.MainApp

/**
 * Created by shucheng.qu on 2018/12/16
 */
object ToastUtils {

    private var toast:Toast = Toast.makeText(MainApp.mContext,"",Toast.LENGTH_SHORT)

    fun showToast(msg:String){
        toast.setText(msg)
        toast.show()
    }

}