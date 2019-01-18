package com.yuan.helper;

import android.app.Application;
import android.content.Context;

import com.bugtags.library.Bugtags;
import com.yuan.helper.base.Download;
import com.yuan.helper.download.Douyin;
import com.yuan.helper.download.QuanMinDSP;
import com.yuan.helper.utils.ThreadHelper;

/**
 * Created by shucheng.qu on 2018/11/12
 */
public class MainApp extends Application {

    public static Context mContext;

    public static Download download = new QuanMinDSP();

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
//        CrashReport.initCrashReport(getApplicationContext(), "11e8fbeee0", false);
        try {
            Bugtags.start("76eabf5a8fa66efdb1c4f3e397150edd", this, Bugtags.BTGInvocationEventBubble);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
