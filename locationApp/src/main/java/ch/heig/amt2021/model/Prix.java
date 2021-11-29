package ch.heig.amt2021.model;

import java.io.Serializable;

public class Prix implements Serializable {


     String cateogire;
     float prix1;
     float prix2;
     float prix3;

    public Prix(String cateogire, float prix1, float prix2, float prix3) {
        this.cateogire = cateogire;
        this.prix1 = prix1;
        this.prix2 = prix2;
        this.prix3 = prix3;
    }

    public String getCateogire() {
        return cateogire;
    }

    public void setCateogire(String cateogire) {
        this.cateogire = cateogire;
    }

    public float getPrix1() {
        return prix1;
    }

    public void setPrix1(int prix1) {
        this.prix1 = prix1;
    }

    public float getPrix2() {
        return prix2;
    }

    public void setPrix2(float prix2) {
        this.prix2 = prix2;
    }

    public float getPrix3() {
        return prix3;
    }

    public void setPrix3(float prix3) {
        this.prix3 = prix3;
    }

}
