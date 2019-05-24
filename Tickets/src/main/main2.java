package main;

import java.sql.*;

public class main2 {
    public static void main(String[] args) throws SQLException{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement statement = connection.prepareStatement("Select * from tickets");
        ResultSet rs = statement.executeQuery();

        while(rs.next())
        {
            String name = rs.getString("ClientName");
            String mail = rs.getString("Mail");
            float price = rs.getFloat("Price");
            System.out.println(name+ "/"+mail + " costs " +price );
        }

    }
}
