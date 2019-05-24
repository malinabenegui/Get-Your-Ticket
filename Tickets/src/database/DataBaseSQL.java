package database;

import java.sql.*;

public class DataBaseSQL {

    private static DataBaseSQL INSTANCE = null;
    private DataBaseSQL(){}

    public static DataBaseSQL getInstance()
    {
        if(INSTANCE == null){
            INSTANCE = new DataBaseSQL();
        }
        return INSTANCE;
    }

    public Connection getConnection()
    {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        }
        catch(Exception e)
        {
            System.out.println("No connection");
            System.out.println(e);
        }
        return connection;
    }
}