package DAO;

import main.Log;
import shows.Cinema;
import shows.Concert;
import shows.Shows;
import shows.Theatre;

import java.io.IOException;
import java.util.*;

public class Client {

    private String clientName, mail, ticketType;
    private float price;
    private int nrTickets;
    Log audit = new Log();

    public Client(String clientName, String mail, String ticketType, float price, int nrTickets)
    {
        this.clientName = clientName;
        this.mail = mail;
        this.ticketType = ticketType;
        this.price = price;
        this.nrTickets = nrTickets;
    }

    /*public float getPriceCinema(CinemaDao cinema) throws IOException
    {
        System.out.println(cinema.getCinemaList());
        System.out.println("Type the name of the wanted movie: ");
        this.showName = new Scanner(System.in).next();
        Cinema wanted = cinema.searchMovie(showName);

        System.out.println("Type your name: ");
        this.clientName = new Scanner(System.in).next();

        System.out.println("Type your mail: ");
        this.mail = new Scanner(System.in).next();

        System.out.println("What type of ticket? (Adult/Student/Child/Retired)");
        this.ticketType = new Scanner(System.in).next();

        System.out.println("How many tickets? ");
        nrTickets = new Scanner(System.in).nextInt();

        Boolean glasses = false;
        if(wanted.isGlass_3d()) //if the movie is 3D, you can buy glasses
        {
            System.out.println("Do you want 3D glasses? True/False");
            glasses = new Scanner(System.in).nextBoolean();
        }*/

        /*this.price = nrTickets*(wanted.calculatePrice(ticketType, glasses));
        System.out.println("The price for this movie is " + price + " ron");

        /*System.out.println("Do you want to purchase the ticket(s)? True/False");
        Boolean purchase = new Scanner(System.in).nextBoolean();
         if(purchase)
        {
            HashMap<Integer, Shows> toAdd = new HashMap<>();
            toAdd.put(nrTickets, wanted);
            clientShows.add(toAdd);
            audit.addToLog("Audit.csv", "Client bought cinema ticket(s)");
        }
        return price;
    }*/

   /* public void addTheatreTicket(TheatreDao theatre) throws IOException
    {
        System.out.println("Type your name: ");
        this.clientName = new Scanner(System.in).next();

        System.out.println("Type your mail: ");
        this.mail = new Scanner(System.in).next();

        System.out.println("What type of ticket? (Adult/Student/Child/Retired)");
        this.ticketType = new Scanner(System.in).next();

        System.out.println(theatre.getTheatreList());
        System.out.println("Type the name of the wanted show: ");
        this.showName = new Scanner(System.in).next();
        Theatre wanted = theatre.searchTheatre(showName);

        System.out.println("How many tickets? ");
        this.nrTickets = new Scanner(System.in).nextInt();

        Boolean lounge = false;
        if(wanted.isLoja()) //if the show has lounge
        {
            System.out.println("Do you want lounge seats? True/False");
            lounge = new Scanner(System.in).nextBoolean();
        }

        this.price = this.nrTickets*(wanted.calculatePrice(this.ticketType, lounge));
        System.out.println("The price for this show is " + this.price + " ron");

        System.out.println("Do you want to purchase the ticket(s)? True/False");
        Boolean purchase = new Scanner(System.in).nextBoolean();

        if(purchase)
        {
            HashMap<Integer, Shows> toAdd = new HashMap<>();
            toAdd.put(nrTickets, wanted);
            clientShows.add(toAdd);
            audit.addToLog("Audit.csv", "Client bought theatre ticket(s)");
        }
    }

    public void addConcTicket(ConcertDao conc) throws IOException
    {
        System.out.println("Type your name: ");
        this.clientName = new Scanner(System.in).next();

        System.out.println("Type your mail: ");
        this.mail = new Scanner(System.in).next();

        System.out.println("What type of ticket? (Adult/Student/Child/Retired)");
        this.ticketType = new Scanner(System.in).next();

        System.out.println(conc.getConcertList());
        System.out.println("Type the name of the wanted concert: ");
        this.showName = new Scanner(System.in).next();
        Concert wanted = conc.searchConcert(this.showName);

        System.out.println("How many tickets? ");
        this.nrTickets = new Scanner(System.in).nextInt();

        Boolean vip = false;
        if(wanted.isVip()) //if the concert has vip access, you can purchase it
        {
            System.out.println("Do you want VIP access? True/False");
            vip = new Scanner(System.in).nextBoolean();
        }

        this.price = this.nrTickets*(wanted.calculatePrice(this.ticketType, vip));
        System.out.println("The price for this show is " + price + " ron");

        System.out.println("Do you want to purchase the ticket(s)? True/False");
        Boolean purchase = new Scanner(System.in).nextBoolean();

        if(purchase)
        {
            HashMap<Integer, Shows> toAdd = new HashMap<>();
            toAdd.put(nrTickets, wanted);
            clientShows.add(toAdd);
            audit.addToLog("Audit.csv", "Client bought theatre ticket(s)");
        }
    }*/

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName +
                ", mail='" + mail +
                ", ticketType='" + ticketType +
                ", price=" + price +
                ", nrTickets=" + nrTickets +
                '}';
    }
}