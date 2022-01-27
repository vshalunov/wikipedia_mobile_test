package com.github.zlwqa.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/realDevice.properties"})
public interface RealDeviceConfig extends Config {

    @Key("deviceName")
    @DefaultValue("Pixel_4_API_30")
    String deviceName();

    @Key("platformName")
    @DefaultValue("android")
    String platformName();

    @Key("Version")
    @DefaultValue("11.0")
    String Version();

    @Key("locale")
    @DefaultValue("en")
    String locale();

    @Key("language")
    @DefaultValue("en")
    String language();

    @Key("appPackage")
    @DefaultValue("org.wikipedia.alpha")
    String appPackage();

    @Key("appActivity")
    @DefaultValue("org.wikipedia.main.MainActivity")
    String appActivity();

    @Key("app")
    @DefaultValue("src/test/resources/apk/app-alpha-universal-release.apk")
    String app();

    @Key("remoteURL")
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    String remoteURL();
}
