package DrinkMachine.src.model.beverage;


class The implements Bevanda {

    @Override
    public String getDescrizione() {
        return "The ";
    }

    @Override
    public double getPrezzo() {
        return 1.5;
    }
}
