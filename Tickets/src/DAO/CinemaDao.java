package DAO;

import shows.Cinema;

import java.util.ArrayList;

public class CinemaDao {

    private ArrayList<Cinema> cinemaList = new ArrayList<>();

    public ArrayList<Cinema> getCinemaList() {
        return cinemaList;
    }
    @Override
    public String toString() {
        return "CinemaDao{" +
                "cinemaList=" + cinemaList +
                '}';
    }


    public void addMovie(Cinema movie)
    {
        cinemaList.add(movie);
    }

    public void deleteMovie(Cinema movie)
    {
        cinemaList.remove(movie);
    }

    public Cinema searchMovie(String name)
    {
        int i;
        for(i = 0; i < cinemaList.size(); i++)
            if(cinemaList.get(i).getName().equals(name))
                return cinemaList.get(i);

        return null;
    }
}
