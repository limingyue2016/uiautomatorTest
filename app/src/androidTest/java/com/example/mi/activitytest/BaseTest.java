package com.example.mi.activitytest;

import android.app.Instrumentation;
import android.content.Context;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


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

}
