package DrinkMachine.src.model.beverage;


public class Latte extends Decorator {

    public Latte(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + latte";
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo() + 0.50;
    }
}
