package main;
/*  */

import DAO.Client;
import shows.Cinema;

import java.util.HashMap;
import java.util.Scanner;

public class ServiceClient extends Main {


    public void output()
    {
        Scanner s = new Scanner(System.in);
        boolean want = true;
        while(want)
        {
            System.out.println("Do you want to buy a ticket or search for a show? Buy/Search");
            String wish = new Scanner(System.in).next();
            if(wish.toLowerCase().equals("buy"))
            {
                System.out.println("What type of show? (Cinema/Theatre/Concert)");
                String showType = new Scanner(System.in).next();
                System.out.println("What type of ticket? (Adult/Student/Child/Retired)");
                String ticketType = new Scanner(System.in).next();
                if(showType.toLowerCase().equals("cinema"))
                {

                    System.out.println(cinema.getCinemaList());
                    System.out.println("Type the name of the wanted movie: ");
                    String name = new Scanner(System.in).next();

                    Client newClient = new Client();
                    Cinema prefferedShow = cinema.searchMovie(name);
                    System.out.println("How many tickets? ");
                    int number = new Scanner(System.in).nextInt();

                    newClient.addTicket(prefferedShow, number);
                }
            }

            System.out.println("Do you want to do another operation? true/false");
            want = s.nextBoolean();
        }

    }
}
