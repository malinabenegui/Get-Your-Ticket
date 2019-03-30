package Shows;

import java.util.Date;

public class Cinema extends Shows {
    private boolean glass_3d;
    private String genres;

    public Cinema(String name, Date data, float price, int noSeatsAvailable, String location, boolean glass_3d)
    {
        super(name, data, price, noSeatsAvailable, location);
        this.glass_3d = glass_3d;
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
