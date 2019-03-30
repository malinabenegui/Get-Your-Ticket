package Shows;

import java.util.Date;

public class Theatre extends Shows {
    private boolean loja;

    public Theatre(String name, Date data, float price, int seatsAvailable, String location, boolean loja)
    {
        super(name, data, price, seatsAvailable, location);
        this.loja = loja;
    }

    public boolean isLoja() {
        return loja;
    }

    public void setLoja(boolean loja) {
        this.loja = loja;
    }
}
