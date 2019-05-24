package main;
/*  */

import DAO.Client;
import database.DataBaseSQL;
import shows.Cinema;
import shows.Concert;
import shows.Theatre;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class ServiceClient extends Main {
    private static ArrayList<HashMap<Client, String>> clientShows = new ArrayList<>();
    public void output() throws IOException
    {
        Log audit = new Log();
        Scanner s = new Scanner(System.in);
        boolean want = true;
        while(want)
        {
            System.out.println("Do you want to buy a ticket or search for a show? Buy/Search");
            String wish = new Scanner(System.in).next();

            //Buy tickets
            if(wish.toLowerCase().equals("buy"))
            {
                //Type client's details
                System.out.println("What type of show? (Cinema/Theatre/Concert)");
                String showType = new Scanner(System.in).next();

                System.out.println("Type your name: ");
                String clientName = new Scanner(System.in).nextLine();

                System.out.println("Type your mail: ");
                String mail = new Scanner(System.in).next();

                System.out.println("What type of ticket? (Adult/Student/Child/Retired)");
                String ticketType = new Scanner(System.in).next();

                System.out.println("How many tickets? ");
                int nrTickets = new Scanner(System.in).nextInt();

                //Buy Cinema ticket
                if(showType.toLowerCase().equals("cinema"))
                {
                    //System.out.println(cinema.getCinemaList());
                    //Print movie list:
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

                    System.out.println("Type the name of the wanted movie: ");
                    String showName = new Scanner(System.in).nextLine();
                    Cinema wanted = cinema.searchMovie(showName);

                    Boolean glasses = false;
                    if(wanted.isGlass_3d()) //if the movie is 3D, you can buy glasses
                    {
                        System.out.println("Do you want 3D glasses? True/False");
                        glasses = new Scanner(System.in).nextBoolean();
                    }

                    float ticketsPrice = nrTickets*(wanted.calculatePrice(ticketType, glasses));
                    System.out.println("The price for this movie is " + ticketsPrice + " ron");
                    Client newClient = new Client(clientName, mail, ticketType, ticketsPrice, nrTickets);

                    System.out.println("Do you want to purchase the ticket(s)? True/False");
                    Boolean purchase = new Scanner(System.in).nextBoolean();

                    if(purchase) //if they still want to buy, purchase tickets
                    {
                        HashMap<Client, String> toAdd = new HashMap<>(); //For CSV
                        toAdd.put(newClient, showName);
                        clientShows.add(toAdd);
                        ServiceClient newServ = new ServiceClient();

                        //Insert new Cinema ticket(s) in database
                        String query = "insert into database.tickets(ClientName, ShowName, Mail, TicketType, Price, NumberOfTickets) values(?, ?, ?, ?, ?, ?)";
                        try {
                            Connection connection = DataBaseSQL.getInstance().getConnection();
                            PreparedStatement statement = connection.prepareStatement(query);

                            statement.setString(1, clientName);
                            statement.setString(3, mail);
                            statement.setString(4, ticketType);
                            statement.setFloat(5, ticketsPrice);
                            statement.setInt(6, nrTickets);
                            statement.setString(2, showName);
                            statement.execute(); //execute  -> true sau false
                            //executeUpdate "delete from database where camp=?"
                            //executeQuerry "Select from"
                            //ResultSet rs = statement.executeQuerry();
                            //execute, executeQuerry, executeUpdate
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }

                        audit.addToLog("Audit.csv", "Client bought cinema ticket(s)");
                    }
                }
                //Buy Theatre ticket
                else if(showType.toLowerCase().equals("theatre"))
                {
                    //System.out.println(theatre.getTheatreList());
                    //Search for theatre shows:
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

                    System.out.println("Type the name of the wanted theatre show: ");
                    String showName = new Scanner(System.in).nextLine();
                    Theatre wanted = theatre.searchTheatre(showName);

                    Boolean lounge= false;
                    if(wanted.isLoja()) //if it has lounge seats available, you can buy seats there
                    {
                        System.out.println("Do you want lounge seats? True/False");
                        lounge = new Scanner(System.in).nextBoolean();
                    }

                    float ticketsPrice = nrTickets*(wanted.calculatePrice(ticketType, lounge));
                    System.out.println("The price for this theatre show is " + ticketsPrice + " ron");
                    Client newClient = new Client(clientName, mail, ticketType, ticketsPrice, nrTickets);

                    System.out.println("Do you want to purchase the ticket(s)? True/False");
                    Boolean purchase = new Scanner(System.in).nextBoolean();

                    if(purchase) //if they still want to buy, purchase tickets
                    {
                        HashMap<Client, String> toAdd = new HashMap<>();
                        toAdd.put(newClient, showName);
                        clientShows.add(toAdd);
                        ServiceClient newServ = new ServiceClient();

                        //Insert new Theatre ticket(s) in database
                        String query = "insert into database.tickets(ClientName, Mail, TicketType, Price, NumberOfTickets, ShowName) values(?, ?, ?, ?, ?, ?)";
                        try {
                            Connection connection = DataBaseSQL.getInstance().getConnection();
                            PreparedStatement statement = connection.prepareStatement(query);

                            statement.setString(1, clientName);
                            statement.setString(3, mail);
                            statement.setString(4, ticketType);
                            statement.setFloat(5, ticketsPrice);
                            statement.setInt(6, nrTickets);
                            statement.setString(2, showName);
                        }
                        catch (Exception e){
                            System.out.println(e);
                        }

                        audit.addToLog("Audit.csv", "Client bought theatre ticket(s)");
                    }
                }
                //Buy Concert ticket
                else if(showType.toLowerCase().equals("concert"))
                {
                    //System.out.println(conc.getConcertList());
                    //Search for concerts:
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
                    System.out.println("Type the name of the wanted concert: ");
                    String showName = new Scanner(System.in).nextLine();
                    Concert wanted = conc.searchConcert(showName);

                    Boolean vip = false;
                    if(wanted.isVip()) //if the movie is 3D, you can buy glasses
                    {
                        System.out.println("Do you want vip access? True/False");
                        vip = new Scanner(System.in).nextBoolean();
                    }

                    float ticketsPrice = nrTickets*(wanted.calculatePrice(ticketType, vip));
                    System.out.println("The price for this concert is " + ticketsPrice + " ron");
                    Client newClient = new Client(clientName, mail, ticketType, ticketsPrice, nrTickets);

                    System.out.println("Do you want to purchase the ticket(s)? True/False");
                    Boolean purchase = new Scanner(System.in).nextBoolean();

                    if(purchase) //if they still want to buy, purchase tickets
                    {
                        HashMap<Client, String> toAdd = new HashMap<>();
                        toAdd.put(newClient, showName);
                        clientShows.add(toAdd);
                        ServiceClient newServ = new ServiceClient();

                        /*DatabaseCSV exportTickets = new DatabaseCSV();
                        exportTickets.newOne();
                        exportTickets.writeTickets(clientShows);*/

                        //Insert new Concert ticket(s) in database
                        String query = "insert into database.tickets(ClientName, Mail, TicketType, Price, NumberOfTickets, ShowName) values(?, ?, ?, ?, ?, ?)";
                        try {
                            Connection connection = DataBaseSQL.getInstance().getConnection();
                            PreparedStatement statement = connection.prepareStatement(query);

                            statement.setString(1, clientName);
                            statement.setString(3, mail);
                            statement.setString(4, ticketType);
                            statement.setFloat(5, ticketsPrice);
                            statement.setInt(6, nrTickets);
                            statement.setString(2, showName);
                        }
                        catch (Exception e){
                            System.out.println(e);
                        }

                        audit.addToLog("Audit.csv", "Client bought concert ticket(s)");
                    }
                }
            }

            //Search for shows
            else if(wish.toLowerCase().equals("search"))
            {
                System.out.println("What type of show? (Cinema/Theatre/Concert)");
                wish = new Scanner(System.in).next();

                //Search for shows in Arrays
                /*if(wish.toLowerCase().equals("cinema"))
                    System.out.println(cinema.getCinemaList());
                else if(wish.toLowerCase().equals("theatre"))
                    System.out.println(theatre.getTheatreList());
                else if(wish.toLowerCase().equals("concert"))
                    System.out.println(conc.getConcertList());*/


                //Search for shows in SQL database
                if(wish.toLowerCase().equals("cinema"))
                {
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
                }
                //Search for Theatre show in SQL database
                else if(wish.toLowerCase().equals("theatre"))
                {
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
                }
                //Search for Concert in SQL database
                else if(wish.toLowerCase().equals("concert"))
                {
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
                }
                audit.addToLog("Audit.csv", "Client searched for a show");
            }
            System.out.println("Do you want to do another operation? true/false");
            want = s.nextBoolean();
        }
    }

    @Override
    public String toString() {
        return "ServiceClient{" +
                "clientShows=" + clientShows +
                '}';
    }
}
