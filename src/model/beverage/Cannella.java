package Drink-Machine.src.model.beverage;

public class Cannella extends Decorator {

    public Cannella(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + cannella";
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo() + 0.20;
    }
}

