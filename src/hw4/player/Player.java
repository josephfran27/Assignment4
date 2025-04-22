package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {

	private Cell currentCell;
	private Row currentRow;

	/**
	 * This is a constructor for a Player, which has currentRow and currentCell attributes to track
	 * their travel. It is clear that these are needed for the player since the test cases have player.getCurrentRow()
	 * and cell.
	 * @param currentRow The row that the player is in.
	 * @param currentCell The cell that the player is in.
	 */
	public Player(Row currentRow, Cell currentCell) {
		setCurrentRow(currentRow);
		setCurrentCell(currentCell);
	}

	/**
	 * Returns the cell of the player.
	 * @return The current cell.
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}

	/**
	 * Sets the cell of the player.
	 * @param currentCell
	 */
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	/**
	 * Returns the current row of the player.
	 * @return The current row of the player.
	 */
	public Row getCurrentRow() {
		return currentRow;
	}

	/**
	 * Sets the row of the player.
	 * @param currentRow
	 */
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	/**
	 * Returns information about the player's location.
	 */
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}



}
