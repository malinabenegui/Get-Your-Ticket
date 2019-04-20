package main;

import database.Database;
import shows.Cinema;
import shows.Concert;
import shows.Theatre;

import java.io.IOException;
import java.util.Scanner;

public class ServiceOwner extends Main{
    public void output() throws IOException
    {
        Log audit = new Log();
        Scanner s = new Scanner(System.in);
        boolean want = true;
        while(want)
        {
            System.out.println("1. Add a show\n");
            System.out.println("2.Delete a show\n");
            System.out.println("3.Export to database\n");
            System.out.println("4.Import database\n");

            int wish = new Scanner(System.in).nextInt();
            if(wish == 1) //Add a show
            {
                System.out.println("Which type of show? Cinema/Theatre/Concert");
                String showType = new Scanner(System.in).next();
                if(showType.toLowerCase().equals("cinema"))
                {
                    System.out.println("Type the name of the movie: ");
                    String name = new Scanner(System.in).next();

                    System.out.println("Type the date of the movie: ");
                    String data = new Scanner(System.in).next();

                    System.out.println("Type the number of available seats: ");
                    int seats = new Scanner(System.in).nextInt();

                    System.out.println("Type the Location: ");
                    String location = new Scanner(System.in).next();

                    System.out.println("Type true if it's a 3D movie or false if not: ");
                    boolean glasses = new Scanner(System.in).nextBoolean();

                    System.out.println("Type the standard price for this movie: ");
                    int price = new Scanner(System.in).nextInt();

                    Cinema movie = new Cinema(name, data, seats, location, glasses, price);
                    cinema.addMovie(movie);
                }
                else if(showType.toLowerCase().equals("concert"))
                {
                    System.out.println("Type the name of the concert: ");
                    String name = new Scanner(System.in).next();

                    System.out.println("Type the date of the concert: ");
                    String data = new Scanner(System.in).next();

                    System.out.println("Type the Location: ");
                    String location = new Scanner(System.in).next();

                    System.out.println("Type true if it has VIP access or false if not: ");
                    boolean vip = new Scanner(System.in).nextBoolean();

                    System.out.println("Type the standard price for this concert: ");
                    int price = new Scanner(System.in).nextInt();

                    Concert newConcert = new Concert(name, data, location, vip, price);
                    conc.addConcert(newConcert);
                }
                else if(showType.toLowerCase().equals("theatre"))
                {
                    System.out.println("Type the name of the theatre show: ");
                    String name = new Scanner(System.in).next();

                    System.out.println("Type the date of the theatre show: ");
                    String data = new Scanner(System.in).next();

                    System.out.println("Type the number of available seats: ");
                    int seats = new Scanner(System.in).nextInt();

                    System.out.println("Type the location: ");
                    String location = new Scanner(System.in).next();

                    System.out.println("Type true if it has lounge seats available or false if not: ");
                    boolean lounge = new Scanner(System.in).nextBoolean();

                    System.out.println("Type the standard price for this theatre show: ");
                    int price = new Scanner(System.in).nextInt();

                    Theatre newTheatre = new Theatre(name, data, seats, location, lounge, price);
                    theatre.addTheatre(newTheatre);
                }
                audit.addToLog("Audit.csv", "Add show");
            }
            else if(wish == 2) //Delete a show
            {
                System.out.println("Which type of show? Cinema/Theatre/Concert");
                String showType = new Scanner(System.in).next();
                if(showType.toLowerCase().equals("cinema"))
                {
                    System.out.println("Type the name of the movie you want to delete: ");
                    String name = new Scanner(System.in).next();
                    Cinema toDelete;
                    toDelete = cinema.searchMovie(name);
                    cinema.deleteMovie(toDelete);
                }
                else if(showType.toLowerCase().equals("concert"))
                {
                    System.out.println("Type the name of the concert you want to delete: ");
                    String name = new Scanner(System.in).next();
                    Concert toDelete;
                    toDelete = conc.searchConcert(name);
                    conc.deleteConcert(toDelete);
                }
                else if(showType.toLowerCase().equals("theatre"))
                {
                    System.out.println("Type the name of the concert you want to delete: ");
                    String name = new Scanner(System.in).next();
                    Theatre toDelete;
                    toDelete = theatre.searchTheatre(name);
                    theatre.deleteTheatre(toDelete);
                }
                audit.addToLog("Audit.csv", "Delete show");
            }
            else if(wish == 3) //Export to database
            {
                /*FileWriter fw = new FileWriter("database.csv",false);

                BufferedWriter bufferedWriter = new BufferedWriter(fw);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                ArrayList<Cinema> tempCinemaList = this.cinema.getCinemaList();
                ArrayList<Theatre> tempTheatreList = this.theatre.getTheatreList();
                ArrayList<Concert> tempConcertList = this.conc.getConcertList();

                if(tempCinemaList.size() != 0)
                    for (int i = 0 ; i< tempCinemaList.size();i++)
                        printWriter.println(tempCinemaList.get(i));
                if(tempConcertList.size() != 0)
                    for (int i = 0 ; i< tempTheatreList.size();i++)
                        printWriter.println(tempTheatreList.get(i));
                if(tempTheatreList.size() != 0)
                    for (int i = 0 ; i< tempConcertList.size();i++)
                        printWriter.println(tempConcertList.get(i));

                printWriter.flush();
                printWriter.close();*/
                Database exportcsv = new Database();
                exportcsv.newOne();
                exportcsv.writeDatabase();
                audit.addToLog("Audit.csv", "Export to Database");
            }

            else if(wish == 4) //Import database
            {
                /*FileReader fileReader = new FileReader("database.csv");
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
                bufferedReader.close();*/

                Database importcsv = new Database();
                importcsv = importcsv.newOne();
                importcsv.readcsv();
                audit.addToLog("Audit.csv", "Import Database");
            }
            System.out.println("Do you want to do another operation? true/false");
            want = s.nextBoolean();
        }
    }
}