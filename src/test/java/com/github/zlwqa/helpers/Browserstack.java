package com.github.zlwqa.helpers;

import com.github.zlwqa.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    private static final MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());

    private static final String userName = mobileConfig.userName();
    private static final String accessKey = mobileConfig.accessKey();

    public static String videoUrl(String sessionId) {
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
