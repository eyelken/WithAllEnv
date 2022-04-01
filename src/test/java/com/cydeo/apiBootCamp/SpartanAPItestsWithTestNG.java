package com.cydeo.apiBootCamp;

import com.cydeo.utilities.ConfigurationReader;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.List;

public class SpartanAPItestsWithTestNG {

    String spartanUrl= ConfigurationReader.get("spartan.apiUrl");
    String hrUrl = ConfigurationReader.get("hr.apiUrl");
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

    @Test
    public void Test2(){
        // get request to all spartans
        // use jspnPath, Gpath syntax

        Response response = given().accept(ContentType.JSON)
                .get(spartanUrl+"/api/spartans");
     //   response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        List<String> maleSpartansNames= jsonPath.getList("findAll{it.gender=='Male'}.name");

        System.out.println("maleSpartansNames.size() = " + maleSpartansNames.size());

        System.out.println("maleSpartansNames.get(1) = " + maleSpartansNames.get(1));

    }

    @Test
    public void Test3(){
        /*
        Send a GET request to ORDS API all regions end point
        check all when the "region_id": 10 then   "region_name" is equal "Cybertek Germany"
         */

        Response response = given().accept(ContentType.JSON)

    }
}
