package com.cydeo.EU7DBboocamp;

import com.cydeo.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class DBConnectionWithTestNG {


    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String query="select name, gender from spartans where name='Oscar'";

    @BeforeMethod
    public void connectToDB() throws SQLException {
        connection = DriverManager.getConnection(ConfigurationReader.get("spartan.DBUrl"),ConfigurationReader.get("spartan.DBusername"),ConfigurationReader.get("spartan.DBpassword"));
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
    }

    @AfterMethod
    public void closeDBconnection() throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }


    @Test
    public void Test1() throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
        }
    }

    @Test
    public void Test2() throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData(); // this object gives us column info

        int columnCount = rsmd.getColumnCount();

        while (resultSet.next()){
            String result="";
            for (int i = 1; i <= columnCount ; i++) {
                result+=" "+resultSet.getString(i);
            }
            System.out.println("result = " + result);
        }

    }

}
