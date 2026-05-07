package model.beverage;

public class Panna extends Decorator {

    public Panna(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + panna";
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo() + 0.50;
    }
}

