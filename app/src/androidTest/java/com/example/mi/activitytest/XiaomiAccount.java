package com.example.mi.activitytest;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class XiaomiAccount extends BaseTest {
//    模拟用户点击 设置-小米帐号 操作
    @Test
    public void aboutPhone () throws UiObjectNotFoundException {
        UiObject2 uiObject2 = device.findObject(By.text("设置"));
        uiObject2.click();

        UiScrollable settings = new UiScrollable(new UiSelector().className("android.widget.FrameLayout"));
        UiObject account = settings.getChildByText(new UiSelector().className("android.widget.LinearLayout"), "小米帐号");
        account.click();

        device.pressBack();
//        device.pressBack();
    }
}
