package model.beverage;

public class Zucchero extends Decorator {

    public Zucchero(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + zucchero";
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo() + 0.05;
    }
}