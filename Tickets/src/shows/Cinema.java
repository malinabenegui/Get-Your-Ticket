package shows;

public class Cinema extends Shows {
    private boolean glass_3d;
    private String genres;
    private int seatsAvailable;
    private String showType = "Cinema";

    public Cinema(String name, String data, int seatsAvailable, String location, boolean glass_3d, float price)
    {
        super(name, data, location, price);
        this.glass_3d = glass_3d;
        this.seatsAvailable = seatsAvailable;
    }

    public Cinema(Cinema c)
    {
        super(c.name, c.data, c.location, c.price);
        this.glass_3d = c.glass_3d;
        this.seatsAvailable = c.seatsAvailable;
    }

    @Override
    public String toString() {
        return showType + "," +
                name + "," +
                data + "," +
                seatsAvailable + "," +
                location + "," +
                glass_3d + "," +
                price;
    }

    public float calculatePrice(String clientType)
    {
        float ticketPrice = 0;
        if(clientType.toLowerCase().equals("student"))
            ticketPrice = price - 50*ticketPrice / 100;
        else if(clientType.toLowerCase().equals("retired"))
            ticketPrice = price - 30*ticketPrice / 100;
        else if(clientType.toLowerCase().equals("child"))
            ticketPrice = price - 70*ticketPrice / 100;
        else ticketPrice = price;

        if(glass_3d == true)
            ticketPrice += 5;

        return ticketPrice;
    }

    public boolean isGlass_3d() {
        return glass_3d;
    }

    public void setGlass_3d(boolean glass_3d) {
        this.glass_3d = glass_3d;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
