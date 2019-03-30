package DAO;

import Shows.Cinema;

import java.util.Date;

public class CinemaDao {
    private Cinema cinemaList[];

    public CinemaDao()
    { cinemaList = new Cinema[1]; }

    public void addMovie(String name, Date data, float price, int noSeatsAvailable, String location, boolean glass_3d)
    {
        int ok = 0;
        Cinema nou = new Cinema(name, data, price, noSeatsAvailable, location, glass_3d);
        Cinema[] aux = new Cinema[cinemaList.length + 1];
        for(int i = 0; i < cinemaList.length; i++)
        {
            aux[i] = new Cinema();
            if(cinemaList[i] == null && ok == 0)
            {
                cinemaList[i] = nou;
                ok = 1; //am gasit o pozitie null pe care sa adaug noul teatru
                break;
            }
            else
            {
                aux[i] = cinemaList[i];
            }
        }

        if(ok == 0) //daca nu am gasit o pozitie null pe care sa adaug
        {
            aux[cinemaList.length] = nou;
            cinemaList = aux;
        }
    }

    public void deleteMovie(String name)
    {

        for(int i = 0; i < cinemaList.length; i++)
        {
            if (cinemaList[i].getName().equals(name))
            {
                cinemaList[i] = null;
            }
        }
    }

    public Cinema SearchMovie(String movie)
    {
        for(int i = 0; i < cinemaList.length; i++)
        {
            if(cinemaList[i].getName().equals(movie))
            {
                return cinemaList[i];
            }
        }
        return null;
    }
}
