package config_new;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constants_new.Constants.RunVeriable.path;
import static constants_new.Constants.RunVeriable.server;
import static constants_new.Constants.Servers.REQUSTE_BIN_URL;
import static constants_new.Constants.Servers.SWAPI_URL;

public class TestConfig {



  protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder()
            .addHeader("Content-Type","application/xml")
            .addCookie("testCookie")
            .setBaseUri(REQUSTE_BIN_URL)
            .build();

    protected RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
            .addHeader("Content-Type","application/json")
            .addCookie("testCookie")
            .build();

    protected ResponseSpecification responseSpecificationForGet = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();

    protected ResponseSpecification responseSpecificationForPost = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();


    @BeforeClass
    public void setUp(){
//        SWAPI_URL = "https://swapi.co/"
        RestAssured.baseURI = server;
//        SWAPI_PATH = "api/"
        RestAssured.basePath = path;

//        для каждого запроса
//        RestAssured.requestSpecification = requestSpecificationJson;
    }

//TODO    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    protected RequestSpecification requestSpecificationForSwapiTests = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL)
            .build();


}
