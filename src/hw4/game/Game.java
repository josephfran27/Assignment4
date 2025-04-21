package hw4.game;

import hw4.maze.Grid;

public class Game {
	
	private Grid grid;
	
	/**
	 * Initializes the grid for the game.
	 * @param grid A grid before manipulating the size.
	 */
	public Game(Grid grid) {
		setGrid(grid);
	}

	/**
	 * Returns the grid of the game.
	 * @return The grid of the game.
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * Sets the grid for the game.
	 * @param grid The grid to be set for the game.
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
		if (grid == null) {
			this.grid = null;
		}
	}
	
	
	

}