package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
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
	 * Initializes the grid but with the random features.
	 * @param size The size of the grid
	 */
	public Game(int size) {
		this.grid = createRandomGrid(size);
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

	/**
	 * This method controls the movement of the player. It ensures that everything is working and then moves the player accross the grid
	 * according to the different features of the grid.
	 * @param movement: The different directions that the player can move.
	 * @param player The player instance
	 * @return Returns false or true based on the players movement.
	 */
	public boolean play(Movement movement, Player player) {

		if (movement == null || player == null || grid == null) {
			return false;
		}

		int currentRowIndex = grid.getRows().indexOf(player.getCurrentRow());
		int currentCellIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());

		if(movement == Movement.UP) {
			//check if player is not on top row already, check if upper part of current  cell is a wall, check if lower part of above cell is a wall
			if (currentRowIndex > 0 && player.getCurrentCell().getUp() != CellComponents.WALL
					&& grid.getRows().get(currentRowIndex - 1).getCells().get(currentCellIndex).getDown() != CellComponents.WALL) {

				//current row is moved up one (-1) and cell index stays the same
				player.setCurrentRow(grid.getRows().get(currentRowIndex - 1));
				player.setCurrentCell(player.getCurrentRow().getCells().get(currentCellIndex));
				return true;

			}
		}
		else if (movement == Movement.DOWN) {
			//check if player is not at the bottom row, check if the lower part of the current cell is a wall, check if the upper part of the lower cell is a wall
			if (currentRowIndex < grid.getRows().size() - 1 && player.getCurrentCell().getDown() != CellComponents.WALL
					&& grid.getRows().get(currentRowIndex + 1).getCells().get(currentCellIndex).getUp() != CellComponents.WALL) {

				//current row is moved down (+1) one and cell index stays the same
				player.setCurrentRow(grid.getRows().get(currentRowIndex + 1));
				player.setCurrentCell(player.getCurrentRow().getCells().get(currentCellIndex));
				return true;
			}
		}
		else if (movement == Movement.LEFT) {
			//check if player is not at the left most row, check if the left part of the current cell is a wall, check if the right side of the left cell is a wall
			if (currentCellIndex > 0 && player.getCurrentCell().getLeft() != CellComponents.WALL
					&& player.getCurrentRow().getCells().get(currentCellIndex - 1).getRight() != CellComponents.WALL) {

				//current cell is moved left (-1)
				player.setCurrentCell(player.getCurrentRow().getCells().get(currentCellIndex - 1));
				return true;
			}
		}
		else if (movement == Movement.RIGHT) {
			//check if player is not at the right most row, check if the right part of the current cell is a wall, check if the left side of the right cell is a wall
			if (currentCellIndex < player.getCurrentRow().getCells().size() - 1 && player.getCurrentCell().getRight() != CellComponents.WALL
					&& player.getCurrentRow().getCells().get(currentCellIndex + 1).getLeft() != CellComponents.WALL) {

				player.setCurrentCell(player.getCurrentRow().getCells().get(currentCellIndex + 1));
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates a random grid with the different cell component features and according to the given size. It starts by doing checks
	 * and then it initializes the different cells with different features according to the rules.
	 * @param size The size of the grid
	 * @return Returns a created grid.
	 */
	public Grid createRandomGrid(int size) {
		if (size < 3 || size > 7) {
			return null;
		}

		ArrayList<Row> rows = new ArrayList<>();
		Random rand = new Random();
		int exitRow = rand.nextInt(size);

		//go row by row initializing each cell with a nested for loop
		for (int i = 0; i < size; i++) {
			ArrayList<Cell> cells = new ArrayList<>();
	
			for (int j = 0; j < size; j++) {
				//start off by initializing each side of the sell to a wall
				CellComponents left = CellComponents.WALL;
				CellComponents right = CellComponents.WALL;
				CellComponents up = CellComponents.WALL;
				CellComponents down = CellComponents.WALL;
	
				//ensure that apertures and cells are synced to pass test
				if (j > 0) {
					left = cells.get(j - 1).getRight(); 
				}
				if (i > 0) {
					up = rows.get(i - 1).getCells().get(j).getDown();
				}
	
				if (rand.nextBoolean()) {
					right = CellComponents.APERTURE;
				}
				if (rand.nextBoolean()) {
					down = CellComponents.APERTURE;
				}
					
				if (j == 0 && i == exitRow) {
					left = CellComponents.EXIT;
				}
	
				if (left != CellComponents.APERTURE && right != CellComponents.APERTURE && up != CellComponents.APERTURE && down != CellComponents.APERTURE) {
					up = CellComponents.APERTURE;
				}
					
	
					cells.add(new Cell(left, right, up, down));
				}
				rows.add(new Row(cells));
			
				}
			return new Grid(rows);
	}

	/**
	 * Returns the components of the grid.
	 */
	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}


}