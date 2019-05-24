package DAO;

import shows.Theatre;

import java.util.ArrayList;

public class TheatreDao {

    private ArrayList<Theatre> theatreList = new ArrayList<>();

    public ArrayList<Theatre> getTheatreList() {
        return theatreList;
    }
    @Override
    public String toString() {
        return "TheatreDao{" +
                "theatreList=" + theatreList +
                '}';
    }

    public void addTheatre(Theatre newTheatre){
        theatreList.add(newTheatre);
    }

    public void deleteTheatre(Theatre toDelete)
    {
        theatreList.remove(toDelete);
    }

    public Theatre searchTheatre(String name)
    {
        int i;
        for(i = 0; i < theatreList.size(); i++)
            if(theatreList.get(i).getName().equals(name))
                return theatreList.get(i);

        return null;
    }
}
