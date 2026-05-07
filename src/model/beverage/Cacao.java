package DrinkMachine.src.model.beverage;

public class Cacao extends Decorator {

    public Cacao(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + " + cacao";
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo() + 0.10;
    }
}