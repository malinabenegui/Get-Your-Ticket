package shows;

public class Theatre extends Shows {
    private boolean loja;
    private static String showType = "Theatre";
    private int seatsAvailable;

    public Theatre(String name, String data, int seatsAvailable, String location, boolean loja, float price)
    {
        super(name, data, location, price);
        this.loja = loja;
        this.seatsAvailable = seatsAvailable;
    }

    public Theatre(Theatre t)
    {
        super(t.name, t.data, t.location, t.price);
        this.loja = t.loja;
        this.seatsAvailable = t.seatsAvailable;
    }

    @Override
    public String toString() {
        return showType + "," +
                name + "," +
                data + "," +
                seatsAvailable + "," +
                location + "," +
                loja + "," +
                price + "\n";
    }

    public float calculatePrice(String clientType, boolean loja)
    {
        float ticketPrice = 0;
        if(clientType.toLowerCase().equals("student"))
            ticketPrice = price - (30*price / 100);
        else if(clientType.toLowerCase().equals("retired"))
            ticketPrice = price - (40*price / 100);
        else if(clientType.toLowerCase().equals("child"))
            ticketPrice = price - (10*price / 100);
        else ticketPrice = price; //for adult

        if(loja == true)
            ticketPrice += 40;

        return ticketPrice;
    }

    public boolean isLoja() {
        return loja;
    }
}
