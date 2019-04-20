package shows;

public abstract class Shows {
    protected String name, location, data;
    protected float price;

    public Shows(String name, String data, String location, float price)
    {
        this.name = name;
        this.data = data;
        this.location = location;
        this.price = price;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
