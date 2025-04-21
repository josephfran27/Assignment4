package hw4.maze;

import java.util.ArrayList;

public class Row {
	
	private ArrayList<Cell> cells; 
	
	/**
	 * This is the row constructor. It is passed a list of the different cells and it creates
	 * it by using the setCells method to ensure proper construction.
	 * @param cells: An ArrayList of the different cell objects. They are put together to create the row.
	 */
	public Row(ArrayList<Cell> cells) {
		setCells(cells);
	}
	
	/**
	 * Returns a list of the specific cell objects in the row.
	 * @return Returns the list of cells.
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}
	
	/**
	 * Creates a row by setting the different cell objects. If any of the cell objects are passed as null, 
	 * the whole field is set to null. This is apparent because in the testSetCellsWithNull method in the test
	 * class, null is compared to row.getCells in assertEquals.
	 * @param cells The cells that are passed and to be used to create the row.
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
		if (cells == null) {
			this.cells = null;
		}
	}
	
	/**
	 * Returns the cells that are in the row.
	 */
	@Override
	public String toString() {
		return "Row [cells="
					+ cells + "]";
	}


}
