package main;

import DAO.CinemaDao;
import DAO.ConcertDao;
import DAO.TheatreDao;
import shows.Cinema;
import shows.Concert;
import shows.Theatre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Main {
    protected static CinemaDao cinema = new CinemaDao();
    protected static ConcertDao conc = new ConcertDao();
    protected static TheatreDao theatre = new TheatreDao();

    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader("database.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Concert newConcert;
        Theatre newTheatre;
        Cinema newCinema;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");

            switch (values[0]) {
                case "Cinema":
                    newCinema = new Cinema(values[1], values[2], parseInt(values[3]), values[4], parseBoolean(values[5]),  parseFloat(values[6]));
                    cinema.addMovie(newCinema);
                    break;
                case "Theatre":
                    newTheatre = new Theatre(values[1], values[2], parseInt(values[3]), values[4], parseBoolean(values[5]),  parseFloat(values[6]));
                    theatre.addTheatre(newTheatre);
                    break;
                case "Concert":
                    newConcert = new Concert(values[1], values[2], values[3], parseBoolean(values[4]),  parseFloat(values[5]));
                    conc.addConcert(newConcert);
                    break;
            }
        }

        bufferedReader.close();
        System.out.println("Client or Owner? Type it: ");
        String type = new Scanner(System.in).next(); //utilisation type (client or owner)
        if(type.toLowerCase().equals("client"))
        {
            ServiceClient client = new ServiceClient();
            client.output();
        }
        else if(type.toLowerCase().equals("owner"))
        {
            System.out.println("Password: ");
            String password = new Scanner(System.in).next(); //Password for owner login
            if(password.equals("ticketapp")) //correct password
            {
                ServiceOwner owner = new ServiceOwner();
                owner.output();
            }
        }
    }
}
