// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
        int lengthRowGrid = grid.length;
        int lengthColumnGrid = grid[0].length;
        int upperBound = 100000, lowerBound = 0, leftBound = 100000, rightBound = 0;

        for (int i = 0; i < lengthRowGrid; i++) {
            for (int j = 0; j < lengthColumnGrid; j++) {
                if (grid[i][j] == ch) {
                    upperBound = Math.min(upperBound, j);
                    lowerBound = Math.max(lowerBound, j);
                    leftBound = Math.min(leftBound, i);
                    rightBound = Math.max(rightBound, i);
                }
            }
        }
        int Area = (lowerBound - upperBound + 1) * (rightBound - leftBound + 1);
        return Area;
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
    private int getArmLength(int indexRow, int indexCol, int directionRow, int directionCol, char ch) {
        int armLength = 1;
        int stepRow = indexRow + directionRow;
        int stepCol = indexCol + directionCol;
        while (stepCol >= 0 && stepCol < grid.length
                && stepRow >= 0 && stepRow < grid.length
                && grid[stepRow][stepCol] == ch) {
            armLength++;
            stepRow += directionRow;
            stepCol += directionCol;
        }
        return armLength;
    }
	public int countPlus() {
		int lengthRow = grid.length;
        int lengthColumn = grid[0].length;
        int countCross = 0;

        for (int i = 1; i < lengthRow - 1; i++) {
            for (int j = 1; j < lengthColumn - 1; j++) {
                if (grid[i][j] == grid[i-1][j]
                    && grid[i][j] == grid[i][j-1]
                    && grid[i][j] == grid[i+1][j]
                    && grid[i][j] == grid[i][j+1]) {
                    int up = getArmLength(i, j, -1, 0 , grid[i][j]);
                    int down = getArmLength(i, j, 1, 0 , grid[i][j]);
                    int left = getArmLength(i, j, 0, -1, grid[i][j]);
                    int right = getArmLength(i, j, 0, 1, grid[i][j]);

                    if (up == down && left == right && up == right) {
                        countCross++;
                    }
                }
            }
        }
        return countCross;
	}
	
}
