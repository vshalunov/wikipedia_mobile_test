package com.github.zlwqa.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/androidMobile.properties"})
public interface MobileConfig extends Config {

    @Key("userName")
    String userName();

    @Key("accessKey")
    String accessKey();

    @Key("appUrl")
    String appUrl();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String device();

    @Key("osVersion")
    @DefaultValue("9.0")
    String osVersion();
}
