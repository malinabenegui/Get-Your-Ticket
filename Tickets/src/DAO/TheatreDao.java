package DAO;

import java.util.*;
import Shows.Theatre;

public class TheatreDao {
    private Theatre[] theatreList;

    public TheatreDao()
    { theatreList = new Theatre[0]; }

    public void addTheatre(String name, Date data, float price, int noSeatsAvailable, String location, boolean loja)
    {
        int ok = 0;
        Theatre nou = new Theatre(name, data, price, noSeatsAvailable, location, loja);
        Theatre[] aux = new Theatre[theatreList.length + 1];
        for(int i = 0; i < theatreList.length; i++)
        {
            aux[i] = new Theatre();
            if(theatreList[i] == null && ok == 0)
            {
                theatreList[i] = nou;
                ok == 1; //am gasit o pozitie null pe care sa adaug noul teatru
                break;
            }
            else
            {
                aux[i] = theatreList[i];
            }
        }

        if(ok == 0) //daca nu am gasit o pozitie null pe care sa adaug
        {
            aux[theatreList.length] = nou;
            theatreList = aux;
        }
    }

    public void deleteTheatre(String name)
    {

        for(int i = 0; i < theatreList.length; i++)
        {
            if (theatreList[i].getName().equals(name))
            {
                theatreList[i] = null;
            }
        }
    }

    public Theatre searchTheatre(String name)
    {

        for(int i = 0; i < theatreList.length;i++)
            if (theatreList[i].getName().equals(name))
            {
                return theatreList[i];
            }
        return null;
    }
}
