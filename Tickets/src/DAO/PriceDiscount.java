package DAO;

public class PriceDiscount {
    public float getStud_price() {
        return stud_price;
    }

    public float getNorm_price() {
        return norm_price;
    }

    public float getRetirPrice() {
        return retirPrice;
    }

    public float getKid_price() {
        return kid_price;
    }

    public void setStud_price(float stud_price) {
        this.stud_price = stud_price;
    }

    public void setNorm_price(float norm_price) {
        this.norm_price = norm_price;
    }

    public void setRetirPrice(float retirPrice) {
        this.retirPrice = retirPrice;
    }

    public void setKid_price(float kid_price) {
        this.kid_price = kid_price;
    }

    private float stud_price, norm_price, retirPrice, kid_price;
}
