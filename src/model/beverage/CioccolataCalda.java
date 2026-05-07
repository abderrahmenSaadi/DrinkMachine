package model.beverage;

public class CioccolataCalda implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Cioccolata calda ";
    }

    @Override
    public double getPrezzo() {
        return 2.0;
    }
}
