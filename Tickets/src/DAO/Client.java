package DAO;

import java.math.BigInteger;

public class Client {

    private String nume, mail, phone;

    public void setPhone(BigInteger phone) {
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
