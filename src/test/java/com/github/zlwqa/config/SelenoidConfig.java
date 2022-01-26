package com.github.zlwqa.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/selenoid.properties"})
public interface SelenoidConfig extends Config {

    @Key("selenoidURL")
    String selenoidURL();

    @Key("login")
    String login();

    @Key("password")
    String password();

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
    @DefaultValue("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk")
    String app();

    @Key("videoStorageURL")
    String videoStorageURL();
}
