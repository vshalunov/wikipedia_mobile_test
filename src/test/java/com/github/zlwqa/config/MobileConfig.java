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
}
