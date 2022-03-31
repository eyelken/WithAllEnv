package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.DBUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import static io.restassured.RestAssured.*;

public class Hooks {

//    @Before(value = "@mock", order=0)
//    public void setUpMock(){
//        baseURI= ConfigurationReader.get("mock.apiUrl");
//    }
//    @Before(value = "@test",order=1)
//    public void setUpTest(){
//        baseURI= ConfigurationReader.get("spartan.apiUrl");
//    }

    @Before
    public void setUp(){
        System.out.println("Some methods before Test Cases");
    }

    @After
    public void tearDown(){
      //  Driver.closeDriver();
    }

    @Before("@db")
    public void connectDB(){
        DBUtils.createConnection();
    }
    @After("@db")
    public void closeDB(){
        DBUtils.destroy();
    }

}
