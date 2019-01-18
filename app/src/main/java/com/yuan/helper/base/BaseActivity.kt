package com.yuan.helper.base

import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.bugtags.library.Bugtags


/**
 * Created by shucheng.qu on 2018/12/15
 */
open class BaseActivity : FragmentActivity() {

    override fun onResume() {
        super.onResume()
        //注：回调 1
        Bugtags.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        //注：回调 2
        Bugtags.onPause(this)
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        //注：回调 3
        Bugtags.onDispatchTouchEvent(this, event)
        return super.dispatchTouchEvent(event)
    }

}