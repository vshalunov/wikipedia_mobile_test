package com.github.zlwqa.helpers;

import com.github.zlwqa.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    private static final BrowserstackConfig BROWSERSTACK_CONFIG = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    private static final String USER_NAME = BROWSERSTACK_CONFIG.userName();
    private static final String ACCESS_KEY = BROWSERSTACK_CONFIG.accessKey();

    public static String getVideoUrl(String sessionId) {
        return given()
                .auth().basic(USER_NAME, ACCESS_KEY)
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}
