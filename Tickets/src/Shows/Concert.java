package Shows;

import java.util.Date;

public class Concert extends Shows {
    private boolean vip;

    public Concert(String name, Date data, float price, int noSeatsAvailable, String location, boolean vip)
    {
        super(name, data, price, noSeatsAvailable, location);
        this.vip = vip;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
