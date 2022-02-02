package com.github.zlwqa.helpers;

import com.github.zlwqa.drivers.BrowserstackMobileDriver;
import com.github.zlwqa.drivers.LocalMobileDriver;
import com.github.zlwqa.drivers.RealDeviceMobileDriver;
import com.github.zlwqa.drivers.SelenoidMobileDriver;

public class RunHelper {

    public static String deviceHost = System.getProperty("deviceHost");

    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        switch (deviceHost) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "selenoid":
                return SelenoidMobileDriver.class;
            case "local":
                return LocalMobileDriver.class;
            case "real":
                return RealDeviceMobileDriver.class;
            default:
                throw new RuntimeException("Необходимо запустить со следующим параметром " +
                        "-DdeviceHost=browserstack/selenoid/local/real");
        }
    }
}
