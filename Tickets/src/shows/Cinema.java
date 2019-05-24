package shows;

public class Cinema extends Shows {
    private boolean glass_3d;
    private int seatsAvailable;
    private String showType = "Cinema";

    public Cinema(String name, String data, int seatsAvailable, String location, boolean glass_3d, float price)
    {
        super(name, data, location, price);
        this.glass_3d = glass_3d;
        this.seatsAvailable = seatsAvailable;
    }

    public Cinema(Cinema c) //Overloading " = "
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
                price + "\n";
    }

    public float calculatePrice(String clientType, boolean glass_3d)
    {
        float ticketPrice = 0;
        if(clientType.toLowerCase().equals("student"))
            ticketPrice = price - (30*price / 100);
        else if(clientType.toLowerCase().equals("retired"))
            ticketPrice = price - (15*price / 100);
        else if(clientType.toLowerCase().equals("child"))
            ticketPrice = price - (50*price / 100);
        else ticketPrice = price;

        if(glass_3d == true) //for 3D glasses, an extra 5 ron is taken
            ticketPrice += 4;

        return ticketPrice;
    }

    public boolean isGlass_3d() {
        return glass_3d;
    }

}
