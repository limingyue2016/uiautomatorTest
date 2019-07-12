package com.example.mi.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends BaseTest{
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        Log.i("ExampleInstrumentedTest", "useAppContext: " + appContext);
        Log.d("ExampleInstrumentedTest", "useAppContext:>>>>>>>>>>>>>>>> "+ appContext);

        assertEquals("com.example.mi.activitytest", appContext.getPackageName());
    }
    @Test
    public void openApp() throws IOException, InterruptedException {
        Log.i("ExampleInstrumentedTest", "openWX>>>");
//        Init.device.executeShellCommand("am start -n com.tencent.mm/com.tencent.mm.ui.LauncherUI");
        device.executeShellCommand("am start -n com.example.mi.activitytest/com.example.mi.activitytest.MainActivity");

//        UiObject2 moreButton = device.findObject(By.text("更多"));
//        UiObject2 loginButton = device.findObject(By.text("登录其他帐号"));
//        Thread.sleep(8000);
//        moreButton.click();
//        Thread.sleep(2000);
//        loginButton.click();

        Thread.sleep(5000);

    }

}
