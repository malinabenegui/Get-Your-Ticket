package DAO;

import Shows.Concert;

import java.util.Date;
import java.util.Set;

public class ConcertDao {

    private Concert concertList[];
    public void addConcert(String name, Date data, float price, int noSeatsAvailable, boolean vip){
        Concert crt = new Concert(name, data, price, noSeatsAvailable, vip);
        Concert[] aux = new Concert[concertList.length + 1];
        for(int i = 0; i < concertList.length; i++)
        {
            aux[i] = concertList[i];
        }
        aux[concertList.length] = crt;
        concertList = aux;
    }

    public void deleteConcert(String name)
    {

        for(int i = 0; i < concertList.length; i++)
        {
            if (concertList[i].getName().equals(name))
            {
                concertList[i] = null;
            }
        }
    }
    public Concert searchConcert(String name)
    {

        for(int i = 0; i < concertList.length;i++)
            if (concertList[i].getName().equals(name))
            {
                return concertList[i];
            }
        return null;
    }
}
