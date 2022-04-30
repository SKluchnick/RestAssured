import config_new.TestConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static constants_new.Constants.Action.*;
import static constants_new.Constants.Path.SWAPI_PATH;
import static constants_new.Constants.Servers.REQUSTE_BIN_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JasonPlaceHolderTest extends TestConfig {
    @Test
    public void GET(){
        given().queryParam("postId",1).log().uri().
                when().get(JSON_PLACEHOLDER_GET).
                then().log().body().statusCode(200);
    }

    @Test
    public void PUT(){
        String putBodyJson = "{\n" +
                "\"id\":1,\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1,\n" +
                "}";
        given().body(putBodyJson).log().uri().
                when().put(JSON_PLACEHOLDER_PUT).
                then().log().body().statusCode(200);
    }

    @Test
    public void DELETE(){
        String putBodyJson = "{\n" +
                "\"id\":1,\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1,\n" +
                "}";
        given().body(putBodyJson).log().uri().
                when().delete(JSON_PLACEHOLDER_DELETE).
                then().log().body().statusCode(200);
    }

    @Test
    public void PostWithJson(){
        String postBodyJson = "{\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1,\n" +
                "}";
        given().body(postBodyJson).log().all().
                when().post(JSON_PLACEHOLDER_POST).
                then().spec(responseSpecificationForPost).log().body();
    }

    @Test
    public void PostWithXml(){
        String postBodyXml = "<?xml version=\"1.0\"?>\n" +
                "<Company>\n" +
                "  <Employee>\n" +
                "      <FirstName>Tanmay</FirstName>\n" +
                "      <LastName>Patil</LastName>\n" +
                "      <ContactNo>1234567890</ContactNo>\n" +
                "      <Email>tanmaypatil@xyz.com</Email>\n" +
                "      <Address>\n" +
                "           <City>Bangalore</City>\n" +
                "           <State>Karnataka</State>\n" +
                "           <Zip>560212</Zip>\n" +
                "      </Address>\n" +
                "  </Employee>\n" +
                "</Company>\n";
        given().spec(requestSpecificationXml).body(postBodyXml).log().all().
                when().post("").
                then().spec(responseSpecificationForGet);
    }

    @Test
    public void validateXmlSchema(){
        given().log().uri()
                .when().get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange")
                .then().body(matchesXsdInClasspath("xmlShema.xsd")).log().body();
    }

    @Test
    public void validateJsonSchema(){
        given().log().uri()
                .when().get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json")
                .then().body(matchesJsonSchemaInClasspath("jsonShema.json")).log().body();
    }

    @Test
    public void getSingleElementWithSomeKey(){
        Response response = given().spec(requestSpecificationForSwapiTests).log()
                .uri()
                .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
        String url = response
                .path("results.find{it.name='Luke Skywalker'}.url");
        System.out.println(url);

    }

    @Test
    public void getAllElementWithSomeKey(){
        Response response = given().spec(requestSpecificationForSwapiTests).log()
                .uri()
                .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
//        System.out.println(response.asString());
        List films = response.path("results.findAll{it.films}.name");
        System.out.println(films);

    }


}
