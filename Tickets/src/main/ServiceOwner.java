package main;

import database.DataBaseSQL;
import database.DatabaseCSV;
import shows.Cinema;
import shows.Concert;
import shows.Theatre;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class ServiceOwner extends Main{
    public void output() throws IOException, SQLException
    {
        Log audit = new Log();
        Scanner s = new Scanner(System.in);
        boolean want = true;
        while(want)
        {
            System.out.println("1. Add a show\n");
            System.out.println("2. Delete a show\n");
            System.out.println("3. Show bought tickets\n");
            //System.out.println("3.Import database\n");
            int wish = new Scanner(System.in).nextInt();

            //Add a show
            if(wish == 1)
            {
                System.out.println("Which type of show? Cinema/Theatre/Concert");
                String showType = new Scanner(System.in).next();

                System.out.println("Type its name: ");
                String name = new Scanner(System.in).nextLine();

                System.out.println("Type its date: ");
                String data = new Scanner(System.in).nextLine();

                System.out.println("Number of available seats: ");
                int seats = new Scanner(System.in).nextInt();

                System.out.println("Location: ");
                String location = new Scanner(System.in).nextLine();

                System.out.println("Standard price: ");
                float price = new Scanner(System.in).nextFloat();

                //Add Cinema show
                if(showType.toLowerCase().equals("cinema"))
                {
                    System.out.println("Type true if it's a 3D movie or false if not: ");
                    boolean glasses = new Scanner(System.in).nextBoolean();

                    Cinema movie = new Cinema(name, data, seats, location, glasses, price);
                    cinema.addMovie(movie);

                    String query = "insert into database.shows(Type, ShowName, Date, Seats, Location, Special, Price) values(?, ?, ?, ?, ?, ?, ?)";

                    try{
                        Connection connection = DataBaseSQL.getInstance().getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1, "Cinema");
                        statement.setString(2, name);
                        statement.setString(3, data);
                        statement.setInt(4, seats);
                        statement.setString(5, location);
                        statement.setBoolean(6, glasses);
                        statement.setFloat(7, price);

                        statement.execute();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
                //Add Concert
                else if(showType.toLowerCase().equals("concert"))
                {
                    System.out.println("Type true if it has VIP access or false if not: ");
                    boolean vip = new Scanner(System.in).nextBoolean();

                    Concert newConcert = new Concert(name, data, location, vip, price);
                    conc.addConcert(newConcert);

                    String query = "insert into database.shows(Type, ShowName, Date, Seats, Location, Special, Price) values(?, ?, ?, ?, ?, ?, ?)";

                    try{
                        Connection connection = DataBaseSQL.getInstance().getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1, "Concert");
                        statement.setString(2, name);
                        statement.setString(3, data);
                        statement.setInt(4, seats);
                        statement.setString(5, location);
                        statement.setBoolean(6, vip);
                        statement.setFloat(7, price);

                        statement.execute();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
                //Add Theatre show
                else if(showType.toLowerCase().equals("theatre"))
                {
                    System.out.println("Type true if it has lounge seats available or false if not: ");
                    boolean lounge = new Scanner(System.in).nextBoolean();

                    Theatre newTheatre = new Theatre(name, data, seats, location, lounge, price);
                    theatre.addTheatre(newTheatre);

                    String query = "insert into database.shows(Type, ShowName, Date, Seats, Location, Special, Price) values(?, ?, ?, ?, ?, ?, ?)";

                    try{
                        Connection connection = DataBaseSQL.getInstance().getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1, "Theatre");
                        statement.setString(2, name);
                        statement.setString(3, data);
                        statement.setInt(4, seats);
                        statement.setString(5, location);
                        statement.setBoolean(6, lounge);
                        statement.setFloat(7, price);

                        statement.execute();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }

                //Export to CSV file the added show
                DatabaseCSV exportcsv = new DatabaseCSV();
                exportcsv.newOne();
                exportcsv.writeDatabase();

                audit.addToLog("Audit.csv", "Show added");
            }
            //Delete a show
            else if(wish == 2)
            {
                System.out.println("Which type of show? Cinema/Theatre/Concert");
                String showType = new Scanner(System.in).next();
                //Delete Cinema movie
                if(showType.toLowerCase().equals("cinema"))
                {
                    //System.out.println(cinema.getCinemaList());
                    //Cinema shows list:
                    try {
                        Connection connection = DataBaseSQL.getInstance().getConnection();
                        PreparedStatement statement = connection.prepareStatement("Select * from database.shows where Type = 'Cinema'");

                        ResultSet rs = statement.executeQuery();
                        while(rs.next())
                        {
                            String show = rs.getString("ShowName");
                            String date = rs.getString("Date");
                            String location = rs.getString("Location");
                            float price = rs.getFloat("Price");
                            System.out.println(show + " " + date + " " + location + " standard price: " + price + " ron");
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Type the name of the movie you want to delete: ");
                    String name = new Scanner(System.in).nextLine();
                    Cinema toDelete;
                    toDelete = cinema.searchMovie(name);
                    cinema.deleteMovie(toDelete);

                    String query = "delete from database.shows where ShowName = ?";
                    try {
                        Connection connection = DataBaseSQL.getInstance().getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1, name);
                        statement.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
                //Delete Concert
                else if(showType.toLowerCase().equals("concert"))
                {
                    //System.out.println(theatre.getTheatreList());
                    //Concerts list:
                    try {
                        Connection connection = DataBaseSQL.getInstance().getConnection();
                        PreparedStatement statement = connection.prepareStatement("Select * from database.shows where Type = 'Concert'");

                        ResultSet rs = statement.executeQuery();
                        while(rs.next())
                        {
                            String show = rs.getString("ShowName");
                            String date = rs.getString("Date");
                            String location = rs.getString("Location");
                            float price = rs.getFloat("Price");
                            System.out.println(show + " " + date + " " + location + " standard price: " + price + " ron");
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Type the name of the concert you want to delete: ");
                    String name = new Scanner(System.in).nextLine();
                    Concert toDelete;
                    toDelete = conc.searchConcert(name);
                    conc.deleteConcert(toDelete);

                    String query = "delete from shows where ShowName = ?";
                    try {
                        Connection connection = DataBaseSQL.getInstance().getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1, name);
                        statement.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
                //Delete Theatre show
                else if(showType.toLowerCase().equals("theatre"))
                {
                    //System.out.println(conc.getConcertList());
                    try {
                        Connection connection = DataBaseSQL.getInstance().getConnection();
                        PreparedStatement statement = connection.prepareStatement("Select * from database.shows where Type = 'Theatre'");

                        ResultSet rs = statement.executeQuery();
                        while(rs.next())
                        {
                            String show = rs.getString("ShowName");
                            String date = rs.getString("Date");
                            String location = rs.getString("Location");
                            float price = rs.getFloat("Price");
                            System.out.println(show + " " + date + " " + location + " standard price: " + price + " ron");
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Type the name of the theatre show you want to delete: ");
                    String name = new Scanner(System.in).nextLine();
                    Theatre toDelete;
                    toDelete = theatre.searchTheatre(name);
                    theatre.deleteTheatre(toDelete);

                    String query = "delete from database.shows where ShowName = ?";
                    try {
                        Connection connection = DataBaseSQL.getInstance().getConnection();
                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1, name);
                        statement.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }

                DatabaseCSV exportcsv = new DatabaseCSV();
                exportcsv.newOne();
                exportcsv.writeDatabase();

                audit.addToLog("Audit.csv", "Deleted one show");
            }

            //Show bought tickets
            else if(wish == 3)
            {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

                    PreparedStatement statement = connection.prepareStatement("Select * from database.tickets");
                    ResultSet rs = statement.executeQuery();

                    while(rs.next())
                    {
                        String name = rs.getString("ClientName");
                        String show = rs.getString("ShowName");
                        String mail = rs.getString("Mail");
                        float price = rs.getFloat("Price");

                        System.out.println(name + " " + mail + " " + show + " costs " + price );
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            //Import database
            /*else if(wish == 3)
            {
                DatabaseCSV importcsv = new DatabaseCSV();
                importcsv = importcsv.newOne();
                importcsv.readcsv();
                audit.addToLog("Audit.csv", "Import DatabaseCSV");
            }*/
            System.out.println("Do you want to do another operation? true/false");
            want = s.nextBoolean();
        }
    }
}