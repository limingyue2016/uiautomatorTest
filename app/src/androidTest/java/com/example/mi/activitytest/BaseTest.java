package com.example.mi.activitytest;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.IOException;


public class BaseTest {
    protected static final String BASIC_SAMPLE_PACKAGE
            = "com.example.mi.activitytest";
    private static final int LAUNCH_TIMEOUT = 5000;
    public static UiDevice device;

    public static Instrumentation instrumentation;

    public static Context context;

    public static Context targetContext;

    @BeforeClass
    public static void beforeClass() {
        Log.i("BaseTest", "beforeClass");
    }

    @Before
    public void setUp() {
        Log.i("BaseTest", "before");
        //  获取设备用例
        instrumentation = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(instrumentation);

        context = instrumentation.getContext();//指向测试包testApplicationId
        targetContext = instrumentation.getTargetContext(); //指向宿主applicationId

        try {
            if(!device.isScreenOn()){
                device.wakeUp();  //唤醒屏幕
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        // Start from the home screen
        device.pressHome();
    }

    @After
    public void after() {
        Log.i("BaseTest", "after");
    }

    @AfterClass
    public static void afterClass() {
        Log.i("BaseTest", "afterClass");
    }


//    启动app
    void startAPP(UiDevice uiDevice, String sPackageName, String sLaunchActivity){
        try {
            uiDevice.executeShellCommand("am start -n " + sPackageName+"/"+sLaunchActivity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//  intent启动app
    void startAPP(String sPackageName){
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(sPackageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
//  关闭app
    void closeAPP(UiDevice uiDevice, String sPackageName) {
        try {
            uiDevice.executeShellCommand("am force-stop" + sPackageName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
