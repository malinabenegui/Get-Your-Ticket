package shows;


public class Concert extends Shows {
    private boolean vip;
    private String showType = "Concert";

    public Concert(String name, String data, String location, boolean vip, float price)
    {
        super(name, data, location, price);
        this.vip = vip;
    }

    public Concert(Concert c)
    {
        super(c.name, c.data, c.location, c.price);
        this.vip = c.vip;
    }

    @Override
    public String toString() {
        return showType + "," +
                name + "," +
                data + "," +
                location + "," +
                vip + "," +
                price + "\n";
    }

    public float calculatePrice(String clientType, boolean vip)
    {
        float ticketPrice = 0;
        if(clientType.toLowerCase().equals("student"))
            ticketPrice = price - (20*price / 100);
        else if(clientType.toLowerCase().equals("retired"))
            ticketPrice = price - (10*ticketPrice / 100);
        else if(clientType.toLowerCase().equals("child"))
            ticketPrice = price - 70*ticketPrice / 100;
        else
            ticketPrice = price;

        if(vip == true)
            ticketPrice *= 2;

        return ticketPrice;
    }

    public boolean isVip() {
        return vip;
    }
}
