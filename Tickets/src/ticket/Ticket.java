package ticket;

public class Ticket {

    private float std_price; //Standard price for cinema

    public float getPrice(String typeClient,  String categShow, boolean special) { //Client
        //price considering the type of the show
        if(categShow.toLowerCase().equals("theatre"))
            std_price = std_price + (100*std_price / 100); //theatre shows are 100% more expensive than movies
        else if(categShow.toLowerCase().equals("concert"))
            std_price = std_price + (130*std_price / 100); //concerts are 130% more expensive than movies

        //price considering 3D glasses, Vip access or lounge seat
        if(special == true)
        {
            std_price += 30*std_price / 100;
        }

        //price considering the type of client
        if(typeClient.toLowerCase().equals("adult"))
            return std_price; //no discount for adults
        else if(typeClient.toLowerCase().equals("student"))
            return std_price - (50*std_price / 100); //50% discount students
        else if(typeClient.toLowerCase().equals("retired"))
            return std_price - (30*std_price / 100); //30% discount for retired
        else if(typeClient.toLowerCase().equals("kid"))
            return std_price - (70*std_price / 100); //70% discount for kids
        return 0;
    }


    public void setStd_price(float std_price) {  //Owner sets the standard price for movies
        this.std_price = std_price;
    }
}
