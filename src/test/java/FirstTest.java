import config_new.TestConfig;
import io.restassured.http.Headers;
import org.testng.annotations.Test;
import io.restassured.response.Response;


import java.util.Map;

import static constants_new.Constants.Action.SWAPI_GET_PEOPLE;
import static constants_new.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest extends TestConfig {
    @Test
    public void myFirstTest() {
        given().log().uri().
//        given().log().all().
//        given().log().ifValidationFails().
//                SWAPI_GET_PEOPLE = "people/"
        when().get(SWAPI_GET_PEOPLE + "1").
//                then().log().body().statusCode(2000);
        then().log().body().statusCode(200);
    }

    @Test
    public void getSomeFieldInResponseAssertion() {
//         requestSpecificationForSwapiTests  "https://swapi.dev/"
        given().spec(requestSpecificationForSwapiTests).log().uri().log().
//                SWAPI_PATH   api/
        uri().when().get(SWAPI_PATH).
                then().body("people", equalTo("https://swapi.dev/api/people/")).log().body();
    }

    @Test
    public void getSomeFieldInResponseAssertionWithIndex() {
//         requestSpecificationForSwapiTests  "https://swapi.dev/"
        given().spec(requestSpecificationForSwapiTests).log().uri().log().
//                SWAPI_PATH   api/
//                SWAPI_GET_PEOPLE   "people/"
        uri().when().get(SWAPI_PATH + SWAPI_GET_PEOPLE).
                then().
                body("count", equalTo(82)).
                body("results.name[0]", equalTo("Luke Skywalker")).
                log().body();
    }

    @Test
    public void getAllDataFromRequest() {
        Response response = given().spec(requestSpecificationForSwapiTests).log()
                .uri()
                .when().get(SWAPI_PATH)
                .then().extract().response();
        String jsonRsponseAsString = response.asString();
        System.out.println(jsonRsponseAsString);
    }

    @Test
    public void getCookieFromResponse(){
        Response response = given().spec(requestSpecificationForSwapiTests).log()
                .uri()
                .when().get(SWAPI_PATH)
                .then().extract().response();
        Map<String, String> allCookies = response.getCookies();
        System.out.println(allCookies);
//              String someCookie = response.getCookie("")

}

    @Test
    public void getHeadersFromResponse(){
        Response response = given().spec(requestSpecificationForSwapiTests).log()
                .uri()
                .when().get(SWAPI_PATH)
                .then().extract().response();
        Headers headers = response.getHeaders();
        System.out.println("ANSWER: " + headers);

        String contentType = response.contentType();
        System.out.println("ANSWER: " + contentType);


    }
}
