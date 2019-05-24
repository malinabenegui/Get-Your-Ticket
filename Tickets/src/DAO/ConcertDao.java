package DAO;

import shows.Concert;

import java.util.ArrayList;

public class ConcertDao {

    private ArrayList<Concert> concertList = new ArrayList<>();

    public ArrayList<Concert> getConcertList() {
        return concertList;
    }

    @Override
    public String toString() {
        return "ConcertDao{" +
                "concertList=" + concertList +
                '}';
    }

    public void addConcert(Concert newConcert){
        concertList.add(newConcert);
    }

    public void deleteConcert(Concert toDelete)
    {
        concertList.remove(toDelete);
    }

    public Concert searchConcert(String name)
    {
        int i;
        for(i = 0; i < concertList.size(); i++)
            if(concertList.get(i).getName().equals(name))
                return concertList.get(i);

        return null;
    }
}
