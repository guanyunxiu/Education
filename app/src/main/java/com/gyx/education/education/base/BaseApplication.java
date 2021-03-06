package com.gyx.education.education.base;

import android.app.Activity;
import android.os.Environment;
import android.support.multidex.MultiDexApplication;
import android.util.Log;


import com.gyx.education.education.config.Constants;
import com.gyx.education.education.config.SharedConstants;
import com.gyx.education.education.utils.DateUtil;
import com.gyx.education.education.utils.SharedPrefUtil;
import com.gyx.education.education.widget.FontsOverride;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import static android.R.attr.x;

/**
 * 内容：
 * Created by 关云秀 on 2017\8\7 0007.
 */

public class BaseApplication extends MultiDexApplication implements
        Thread.UncaughtExceptionHandler {
    private static BaseApplication mApplication;
    public static List<Activity> activityList = new LinkedList<Activity>();
    public static SharedPrefUtil mSharedPrefUtil;


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mSharedPrefUtil = new SharedPrefUtil(this, SharedConstants.sharersinfor);
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/PingFang Bold.ttf");
        //启动异常捕获线程
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static BaseApplication getInstance() {
        return mApplication;
    }

    public void removeActivity(Activity act, int index) {
        if (activityList != null && !activityList.isEmpty()) {
            activityList.remove(act);
        }
    }

    public void addActivity(Activity act) {
        if (activityList != null) {
            activityList.add(act);
        }
    }

    public List<Activity> getActivityList() {
        return activityList;
    }


    public static void removeActivity() {
        Log.i("activityList", activityList.size() + "***");
        //
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }


    //保存错误日志到本地文件夹
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (null == ex)
            return;

        setErrorInfor(thread, ex);
    }

    public void setErrorInfor(final Thread thread, final Throwable ex) {

        outLog(ex);
        if (null != defaultUncaughtExceptionHandler)
            defaultUncaughtExceptionHandler.uncaughtException(thread, ex);

    }

    //打印错误日志
    public void outLog(Throwable ex) {
        File sdFile = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File sdCardDir = Environment.getExternalStorageDirectory();//获取SDCard目录
            sdFile = new File(sdCardDir, Constants.WORNGFILE);
            final int MAX_SIZE = 1 * 1024 * 1024; // 1M
            boolean append = true;
            if (sdFile.length() > MAX_SIZE) {
                append = false;
            }
            try {
                FileOutputStream fos = new FileOutputStream(sdFile, append);
                PrintWriter printWriter = new PrintWriter(fos);
                String bar = "----------------------------";
                printWriter.append(bar + DateUtil.curChinaFormatDate() + bar);//系統时间
                printWriter.append(bar + android.os.Build.MODEL + bar);//手机型号
                printWriter.append("\n");
                ex.printStackTrace(printWriter);
                printWriter.close();
                fos.close();  //关闭输出流

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

}
