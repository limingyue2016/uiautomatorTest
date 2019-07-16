package com.example.mi.activitytest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
//  通过以上标识可以知道该类为一个测试集合
public class ExampleInstrumentedTest extends BaseTest {
    private String mPackageName = "com.example.mi.activitytest";
    private String sLaunchActivity = "com.example.mi.activitytest.MainActivity";

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.mi.activitytest", appContext.getPackageName());
    }

    @Test
    public void openApp() throws InterruptedException {

//        device.executeShellCommand("am start -n com.example.mi.activitytest/com.example.mi.activitytest.MainActivity");
        startAPP(device,mPackageName,sLaunchActivity);

        device.waitForWindowUpdate(mPackageName, 2 * 2000);


        UiObject2 button1 = device.findObject(By.clazz("android.widget.Button").text("BUTTON1"));
        button1.click();
        Thread.sleep(2000);
        UiObject2 button2 = device.findObject(By.clazz("android.widget.Button").text("BUTTON2"));
        button2.click();
        UiCollection uiCollections = new UiCollection(new UiSelector().className("android.widget.Button"));
        int count = uiCollections.getChildCount(new UiSelector().className("android.widget.Button"));
        Log.i(TAG, "openApp------------------------: "+count);

//        closeAPP(device,mPackageName);

    }
}
