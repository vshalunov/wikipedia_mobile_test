package com.github.zlwqa.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/local.properties"})
public interface LocalConfig extends Config {

    @DefaultValue("Pixel_4_API_30")
    String deviceName();

    @DefaultValue("android")
    String platformName();

    @DefaultValue("11.0")
    String Version();

    @DefaultValue("en")
    String locale();

    @DefaultValue("en")
    String language();

    @DefaultValue("org.wikipedia.alpha")
    String appPackage();

    @DefaultValue("org.wikipedia.main.MainActivity")
    String appActivity();

    @DefaultValue("src/test/resources/apk/app-alpha-universal-release.apk")
    String app();

    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    String remoteURL();
}
