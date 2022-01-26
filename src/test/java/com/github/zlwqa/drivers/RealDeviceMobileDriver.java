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

    private static final String platformName = REAL_DEVICE_CONFIG.platformName();
    private static final String deviceName = REAL_DEVICE_CONFIG.deviceName();
    private static final String Version = REAL_DEVICE_CONFIG.Version();
    private static final String locale = REAL_DEVICE_CONFIG.locale();
    private static final String language = REAL_DEVICE_CONFIG.language();
    private static final String appPackage = REAL_DEVICE_CONFIG.appPackage();
    private static final String appActivity = REAL_DEVICE_CONFIG.appActivity();
    private static final String app = REAL_DEVICE_CONFIG.app();
    private static final String remoteURL = REAL_DEVICE_CONFIG.remoteURL();

    public static URL getLocalstackUrl() {
        try {
            return new URL(remoteURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("version", Version);
        desiredCapabilities.setCapability("locale", locale);
        desiredCapabilities.setCapability("language", language);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("app", getAbsolutePath(app));

        return new AndroidDriver(getLocalstackUrl(), desiredCapabilities);
    }

}
