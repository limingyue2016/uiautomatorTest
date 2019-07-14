package com.example.mi.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
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
public class ExampleInstrumentedTest extends BaseTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.mi.activitytest", appContext.getPackageName());
    }

    @Test
    public void openApp() throws IOException, InterruptedException, UiObjectNotFoundException {
//        device.executeShellCommand("am start -n com.tencent.mm/com.tencent.mm.ui.LauncherUI");
//        device.executeShellCommand("am start -n com.example.mi.activitytest/com.example.mi.activitytest.MainActivity");
//        启动测试app
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.example.mi.activitytest");
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
        Thread.sleep(2000);
//      点击settings按钮
        UiObject2 uiObject2 = device.findObject(By.text("设置"));
        uiObject2.click();

        // 滑动列表到最后，点击About phone选项
       UiScrollable settings = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));
       UiObject about = settings.getChildByText(new UiSelector().className("android.widget.LinearLayout"), "关于手机");
       about.click();

       device.pressBack();
       device.pressBack();

    }

}
