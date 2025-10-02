//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
        int width = grid.length;
        int heigh = grid[0].length;
        int currentRowAfterDeleted = 0;

        for (int i = 0; i < heigh; i++) {
            if (!rowIsFullTrue(i)) {
                for (int j = 0; j < width; j++) {
                    grid[j][currentRowAfterDeleted] = grid[j][i];
                }
                currentRowAfterDeleted++;
            }
        }

        for (int i = currentRowAfterDeleted; i < heigh; i++) {
            for (int j = 0; j < width; j++) {
                grid[j][i] = false;
            }
        }
	}

    private boolean rowIsFullTrue(int indexCol) {
        int width = grid.length;
        for (int i = 0; i < width; i++) {
            if (grid[i][indexCol] == false) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
        return grid;
	}
}
