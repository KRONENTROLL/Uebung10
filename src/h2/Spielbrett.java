package h2;

public class Spielbrett {
    private int dim;
    private Feld[][] brett;

    public Feld[][] getBrett() {
        return brett;
    }
    public int getDim() {
        return dim;
    }

    public Spielbrett(int dim) {
        this.dim = dim;
        brett = new Feld[dim][dim];
    }
}
