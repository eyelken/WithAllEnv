package com.cydeo.apiBootCamp;

import com.cydeo.utilities.ConfigurationReader;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class SpartanAPItestsWithTestNG {

    String spartanUrl= ConfigurationReader.get("spartan.apiUrl");
    @Test
    public void Test1(){
        Response response = given().accept(ContentType.JSON)
                .queryParam("nameContains","Fe")
                .and().queryParam("gender","Female")
                .get(spartanUrl+"/api/spartans/search");
        response.prettyPrint();
        assertTrue(response.statusCode() == 200);
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.header("Transfer-Encoding"),"chunked");
        assertTrue(response.headers().hasHeaderWithName("Date"));
        assertEquals(response.body().path("content[0].name"),"Fenelia");
        System.out.println("response.getTime() = " + response.getTime());
    }
}
