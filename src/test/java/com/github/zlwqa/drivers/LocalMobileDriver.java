package com.github.zlwqa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.zlwqa.config.LocalConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.github.zlwqa.utils.FileUtils.getAbsolutePath;

public class LocalMobileDriver implements WebDriverProvider {

    private static final LocalConfig LOCAL_MOBILE_DRIVER = ConfigFactory.create(LocalConfig.class, System.getProperties());

    private static final String platformName = LOCAL_MOBILE_DRIVER.platformName();
    private static final String deviceName = LOCAL_MOBILE_DRIVER.deviceName();
    private static final String Version = LOCAL_MOBILE_DRIVER.Version();
    private static final String locale = LOCAL_MOBILE_DRIVER.locale();
    private static final String language = LOCAL_MOBILE_DRIVER.language();
    private static final String appPackage = LOCAL_MOBILE_DRIVER.appPackage();
    private static final String appActivity = LOCAL_MOBILE_DRIVER.appActivity();
    private static final String app = LOCAL_MOBILE_DRIVER.app();
    private static final String remoteURL = LOCAL_MOBILE_DRIVER.remoteURL();

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
