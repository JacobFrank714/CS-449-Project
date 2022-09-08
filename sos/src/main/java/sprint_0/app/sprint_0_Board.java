package sprint_0.app;

public class sprint_0_Board {
    private int[][] grid;
	private char turn = 'X';

	public sprint_0_Board(int x) {
		grid = new int[x][x];
	}

	public int getCell(int row, int column) {
		return grid[row][column];
	}

	public char getTurn() {
		return turn;
	}
}
