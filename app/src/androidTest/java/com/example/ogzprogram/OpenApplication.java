package com.example.ogzprogram;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

class OpenApplication {

    private static final int LAUNCH_TIMEOUT = 6000;
    private final String PACKAGE;

    public OpenApplication(String pack) {
        this.PACKAGE = pack;
    }

    public void open() {

        // Initialize UiDevice instance
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        try {
            assertTrue("Tablet screen not turned on!", mDevice.isScreenOn());
        } catch (RemoteException exc) {
            return;
        }
        // Start from the home screen
        mDevice.pressHome();
        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);
        // Launch the blueprint app
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);
        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getInstrumentation().getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
