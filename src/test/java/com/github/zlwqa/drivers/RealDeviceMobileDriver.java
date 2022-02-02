package com.github.zlwqa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.zlwqa.config.RealDeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.github.zlwqa.utils.FileUtils.getAbsolutePath;

public class RealDeviceMobileDriver implements WebDriverProvider {

    private static final RealDeviceConfig REAL_DEVICE_CONFIG = ConfigFactory.create(RealDeviceConfig.class, System.getProperties());

    private static final String PLATFORM_NAME = REAL_DEVICE_CONFIG.platformName();
    private static final String DEVICE_NAME = REAL_DEVICE_CONFIG.deviceName();
    private static final String VERSION = REAL_DEVICE_CONFIG.Version();
    private static final String LOCALE = REAL_DEVICE_CONFIG.locale();
    private static final String LANGUAGE = REAL_DEVICE_CONFIG.language();
    private static final String APP_PACKAGE = REAL_DEVICE_CONFIG.appPackage();
    private static final String APP_ACTIVITY = REAL_DEVICE_CONFIG.appActivity();
    private static final String APP = REAL_DEVICE_CONFIG.app();
    private static final String REMOTE_URL = REAL_DEVICE_CONFIG.remoteURL();

    public static URL getLocalstackUrl() {
        try {
            return new URL(REMOTE_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
        desiredCapabilities.setCapability("deviceName", DEVICE_NAME);
        desiredCapabilities.setCapability("version", VERSION);
        desiredCapabilities.setCapability("locale", LOCALE);
        desiredCapabilities.setCapability("language", LANGUAGE);
        desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
        desiredCapabilities.setCapability("app", getAbsolutePath(APP));

        return new AndroidDriver(getLocalstackUrl(), desiredCapabilities);
    }

}
