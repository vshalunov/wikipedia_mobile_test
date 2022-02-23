package com.github.zlwqa.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/browserstack.properties"})
public interface BrowserstackConfig extends Config {

    String userName();

    String accessKey();

    String appUrl();

    @DefaultValue("Google Pixel 3")
    String deviceName();

    @DefaultValue("9.0")
    String osVersion();

    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String remoteURL();
}
