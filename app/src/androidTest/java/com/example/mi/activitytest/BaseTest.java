package com.example.mi.activitytest;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


public class BaseTest extends Init{
    private static final String BASIC_SAMPLE_PACKAGE
            = "com.example.mi.activitytest";
    private static final int LAUNCH_TIMEOUT = 5000;
    @BeforeClass
    public static void beforeClass(){
        Log.i("BaseTest","beforeClass");
        Init.work();

    }
    @Before
    public void before(){
        Log.i("BaseTest","before");

        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // Start from the home screen
        device.pressHome();

    }

    @After
    public void after(){
        Log.i("BaseTest","after");
    }

    @AfterClass
    public static void afterClass(){
        Log.i("BaseTest","afterClass");
    }

}
