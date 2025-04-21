package hw4.maze;

import java.util.ArrayList;

public class Grid {
	
	private ArrayList<Row> rows;
	
	/**
	 * This is the grid constructor. The grid is created using the list of row objects.
	 * @param rows: An ArrayList of the different rows.
	 */
	public Grid(ArrayList<Row> rows) {
		setRows(rows);
	}
	
	/**
	 * Returns a list of the different rows in the grid.
	 * @return Returns the list of rows.
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}
	
	/**
	 * Creates a grid using the different row objects and performing test cases, similar to the setter
	 * of the rows.
	 * @param rows
	 */
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
		if (rows == null) {
			this.rows = null;
		}
	}
	
	/**
	 * Returns the rows in the grid.
	 */
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
	
	
	

}
