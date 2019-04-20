package database;

import main.Main;
import shows.Cinema;
import shows.Concert;
import shows.Theatre;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Database extends Main {

    private static Database data;

    public static Database newOne(){
        if(data == null)
        {
            data = new Database();
            return data;
        }
        return data;
    }

    public void writeDatabase(){
        PrintWriter printWriter = null;
        try{
            FileWriter fw = new FileWriter("database.csv",false);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            printWriter = new PrintWriter(bufferedWriter);
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
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                printWriter.flush();
                printWriter.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void readcsv(){
        BufferedReader bufferedReader = null;

        try {
            FileReader fileReader = new FileReader("database.csv");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            Concert newConcert;
            Theatre newTheatre;
            Cinema newCinema;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");

                switch (values[0]) {
                    case "Cinema":
                        newCinema = new Cinema(values[1], values[2], parseInt(values[3]), values[4], parseBoolean(values[5]), parseFloat(values[6]));
                        cinema.addMovie(newCinema);
                        break;
                    case "Theatre":
                        newTheatre = new Theatre(values[1], values[2], parseInt(values[3]), values[4], parseBoolean(values[5]), parseFloat(values[6]));
                        theatre.addTheatre(newTheatre);
                        break;
                    case "Concert":
                        newConcert = new Concert(values[1], values[2], values[3], parseBoolean(values[4]), parseFloat(values[5]));
                        conc.addConcert(newConcert);
                        break;
                }
            }
        }
        catch(Exception e){
                e.printStackTrace();
            }

        finally {
            try{
                bufferedReader.close();
            }
        catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
