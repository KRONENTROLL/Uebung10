package h2;

public class Feld {
    private  boolean boese;
    private char direction;

    public boolean getBoese() {
        return boese;
    }
    public void setBoese(boolean boese) {
        this.boese = boese;
    }

    public char getDirection() {
        return direction;
    }
    public void setDirection(char direction) {
        this.direction = direction;
    }

    public Feld(boolean boese, char direction) {
        this.boese = boese;
        this.direction = direction;
    }
}
