package hw4.game;

import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.player.Player;

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
	
	public boolean play(Movement movement, Player player) {
		
		int currentRowIndex = grid.getRows().indexOf(player.getCurrentRow());
		int currentCellIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
		
		if(movement == Movement.UP) {
			//check if player is not on top row already, check if upper part of current  cell is a wall, check if lower part of above cell is a wall
			if (currentRowIndex > 0 && player.getCurrentCell().getUp() != CellComponents.WALL 
					&& grid.getRows().get(currentRowIndex - 1).getCells().get(currentCellIndex).getDown() != CellComponents.WALL) {
				return true;
			}
		}
		else if (movement == Movement.DOWN) {
			//check if player is not at the bottom row, check if the lower part of the current cell is a wall, check if the upper part of the lower cell is a wall
			if (currentRowIndex < grid.getRows().size() - 1 && player.getCurrentCell().getDown() != CellComponents.WALL 
					&& grid.getRows().get(currentRowIndex + 1).getCells().get(currentCellIndex).getUp() != CellComponents.WALL) {
				return true;
			}
		}
		else if (movement == Movement.LEFT) {
			//check if player is not at the left most row, check if the left part of the current cell is a wall, check if the right side of the left cell is a wall
			if (currentCellIndex > 0 && player.getCurrentCell().getLeft() != CellComponents.WALL
					&& player.getCurrentRow().getCells().get(currentCellIndex - 1).getRight() != CellComponents.WALL) {
				return true;
			}
		}
		else if (movement == Movement.RIGHT) {
			//check if player is not at the right most row, check if the right part of the current cell is a wall, check if the left side of the right cell is a wall
			if (currentCellIndex < player.getCurrentRow().getCells().size() - 1 && player.getCurrentCell().getRight() != CellComponents.WALL
					&& player.getCurrentRow().getCells().get(currentCellIndex + 1).getLeft() != CellComponents.WALL) {
				return true;
			}
		}
		return false;
	}
	

}