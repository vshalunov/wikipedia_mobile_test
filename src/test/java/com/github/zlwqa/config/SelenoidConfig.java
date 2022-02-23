package com.github.zlwqa.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/selenoid.properties"})
public interface SelenoidConfig extends Config {

    String selenoidURL();

    String login();

    String password();

    @DefaultValue("android")
    String deviceName();

    @DefaultValue("android")
    String platformName();

    @DefaultValue("8.1")
    String Version();

    @DefaultValue("en")
    String locale();

    @DefaultValue("en")
    String language();

    @DefaultValue("org.wikipedia.alpha")
    String appPackage();

    @DefaultValue("org.wikipedia.main.MainActivity")
    String appActivity();

    @DefaultValue("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk")
    String appURL();

    String videoStorageURL();
}
