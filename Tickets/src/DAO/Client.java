package DAO;

import shows.Shows;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Client {

    private String nume, mail, phone;
    private ArrayList<HashMap<Integer, Shows>> clientShows = new ArrayList<>();

    public void addTicket(Shows s, int nr)
    {
        HashMap<Integer, Shows> toAdd = new HashMap<>();
        toAdd.put(nr, s);
        clientShows.add(toAdd);
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getNume() {
        return nume;
    }

    public String getMail() {
        return mail;
    }
}
