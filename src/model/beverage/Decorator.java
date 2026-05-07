public abstract class Decorator implements Bevanda {

    protected Bevanda bevanda;

    public Decorator(Bevanda bevanda) {
        this.bevanda = bevanda;
    }

}

interface Bevanda {

    String getDescrizione();

    double getPrezzo();
}

class Caffe implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Caffè ";
    }

    @Override
    public double getPrezzo() {
        return 1.0;
    }

}

class CioccolataCalda implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Cioccolata calda ";
    }

    @Override
    public double getPrezzo() {
        return 2.0;
    }
}

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



class Latte extends Decorator {

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

class Cacao extends Decorator {

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


class Cannella extends Decorator {

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


class Panna extends Decorator {

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



class Zucchero extends Decorator {

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