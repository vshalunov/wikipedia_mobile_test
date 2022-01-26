package com.github.zlwqa.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/browserstack.properties"})
public interface BrowserstackConfig extends Config {

    @Key("userName")
    String userName();

    @Key("accessKey")
    String accessKey();

    @Key("appUrl")
    String appUrl();

    @Key("deviceName")
    @DefaultValue("Google Pixel 3")
    String deviceName();

    @Key("osVersion")
    @DefaultValue("9.0")
    String osVersion();

    @Key("remoteURL")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String remoteURL();
}
