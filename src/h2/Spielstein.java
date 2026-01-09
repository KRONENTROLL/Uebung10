package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public int getCurrentRow() { return currentRow; }
    public void setCurrentRow(int currentRow) { this.currentRow = currentRow; }

    public int getCurrentCol() { return currentCol; }
    public void setCurrentCol(int currentCol) { this.currentCol = currentCol; }

    public Spielbrett getBrett() { return brett; }
    public void setBrett(Spielbrett brett) { this.brett = brett; }

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    private boolean movesOut() {
        Feld currentField = brett.getBrett()[currentRow][currentCol];
        return switch (currentField.getDirection()) {
            case 'U' -> currentRow == 0;
            case 'D' -> currentRow == brett.getDim() - 1;
            case 'L' -> currentCol == 0;
            case 'R' -> currentCol == brett.getDim() - 1;
            default -> false;
        };
    }

    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld currentField = brett.getBrett()[currentRow][currentCol];

            if (currentField.getBoese() || movesOut()) {
                break;
            }

            int nextRow = currentRow;
            int nextCol = currentCol;
            switch (currentField.getDirection()) {
                case 'U' -> nextRow--;
                case 'D' -> nextRow++;
                case 'L' -> nextCol--;
                case 'R' -> nextCol++;
            }

            if (nextRow >= 0 && nextRow < brett.getDim() && nextCol >= 0 && nextCol < brett.getDim()) {
                currentRow = nextRow;
                currentCol = nextCol;
            } else {
                break;
            }
        }
    }
}
