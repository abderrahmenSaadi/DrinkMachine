package model.beverage;
public abstract class Decorator implements Bevanda {

    protected Bevanda bevanda;

    public Decorator(Bevanda bevanda) {
        this.bevanda = bevanda;
    }

}