package com.example.mi.activitytest;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

public class Init {
    public static UiDevice device;

    public static Instrumentation instrumentation;

    public static Context context;

    public static Context targetContext;

    public static void work() {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(instrumentation);
        context = instrumentation.getContext();//指向测试包testApplicationId
        targetContext = instrumentation.getTargetContext(); //指向宿主applicationId
    }
}
