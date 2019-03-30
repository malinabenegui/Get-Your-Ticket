package Shows;


import java.util.Date;

public abstract class Shows {
    protected String name, location;
    protected Date data;
    protected float price;
    protected int seatsAvailable;

    public Shows(String name, Date data, float price, int seatsAvailable, String location)
    {
        this.name = name;
        this.data = data;
        this.price = price;
        this.seatsAvailable = seatsAvailable;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isNoSeatsAvailable() {
        return noSeatsAvailable;
    }

    public void setNoSeatsAvailable(boolean noSeatsAvailable) {
        this.noSeatsAvailable = noSeatsAvailable;
    }
}
