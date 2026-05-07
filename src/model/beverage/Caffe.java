package beverage;

public class Caffe implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Caffè ";
    }

    @Override
    public double getPrezzo() {
        return 1.0;
    }

}
