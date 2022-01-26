package com.github.zlwqa.helpers;

import com.github.zlwqa.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class BrowserstackVideoUrl {

    private static final BrowserstackConfig BROWSERSTACK_CONFIG = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    private static final String userName = BROWSERSTACK_CONFIG.userName();
    private static final String accessKey = BROWSERSTACK_CONFIG.accessKey();

    public static String getVideoUrl(String sessionId) {
        return given()
                .auth().basic(userName, accessKey)
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}
