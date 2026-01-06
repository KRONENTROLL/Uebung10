package h1;

public class Grid {
    private Cell[][] gridArray;


    public Cell[][] getGridArray() {
        return gridArray;
    }


    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }


    public Grid(Cell[] cells, int gridRows, int gridCols) {
        gridArray = new Cell[gridRows][gridCols];

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j] = new Cell(i, j, false);
            }
        }

        for (Cell c : cells) {
            int row = c.getIndexRow();
            int col = c.getIndexCol();
            if (row >= 0 && row < gridRows && col >= 0 && col < gridCols) {
                gridArray[row][col].setAlive(true);
            }
        }

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }
    }


    public void computeNextGen () {
        int rows = gridArray.length;
        int cols = gridArray[0].length;

        for (Cell[] cells : gridArray) {
            for (int c = 0; c < cols; c++) {
                cells[c].countLivingNeighbors(gridArray);
            }
        }

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                gridArray[r][c].setAlive(gridArray[r][c].isAliveNextGen());
            }
        }
    }


    public void computeGeneration (int n) {
        if (n <= 0) return;

        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }
}
