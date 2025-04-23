package hw4.simulation;

import java.util.Random;
import java.util.Scanner;

import hw4.game.Game;
import hw4.game.Movement;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Player;

public class Simulation {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		Random rand = new Random();
		int size = rand.nextInt(5) + 3;
		Game game = new Game(size);
		Grid grid = game.getGrid();
		
		Row startingRow = grid.getRows().get(size - 1);
		Cell startingCell = startingRow.getCells().get(size - 1);
		
		Player agent = new Player(startingRow, startingCell);
		
		System.out.println("Welcome to the maze! Move with... ");
		System.out.println("--- W = Up, S = Down, A = Left, D = Right ---");
		System.out.println("Initial Grid:");
		printGrid(grid, agent);
		
		boolean out = false;
		
		//repeat while loop and input collection until escaped 
		while(out != true) {

			//ensure that input matches requirements
			System.out.println("Make your choice!: ");
			String input = scanner.nextLine();
			
			Movement choice = null;
			
			if(input.equals("W")) {
				choice = Movement.UP;
			}
			else if(input.equals("S")) {
				choice = Movement.DOWN;
			}
			else if(input.equals("A")) {
				choice = Movement.LEFT;
			}
			else if(input.equals("D")) {
				choice = Movement.RIGHT;
			}
			else {
				System.out.println("Invalid input.");
				continue;
			}
			
			Cell current = agent.getCurrentCell();
			int cellIndex = agent.getCurrentRow().getCells().indexOf(current);
			
			//Agent is out if they choose to move left and it is the exit
			if (choice == Movement.LEFT && current.getLeft() == CellComponents.EXIT && cellIndex == 0) {
				out = true;
				System.out.println("You have escaped!");
				break;
			}
			
			//check if move was successful
			boolean moved = game.play(choice, agent);
			if(moved == false) {
				System.out.println("You have ran into a wall!");
			}
			
			System.out.println("\nUpdated Grid...");
			printGrid(grid, agent);
		}
		scanner.close();
	}

	
	private static void printGrid(Grid grid, Player agent) {
		for (int i = 0; i < grid.getRows().size(); i ++) {
			Row row = grid.getRows().get(i);
			for (int j = 0; j < row.getCells().size(); j++) {
				
				Cell cell = row.getCells().get(j);
				
				//use symbol instead of println to prevent each character from being on a new line (looked it up on the Internet)
				String symbol;
				if(cell == agent.getCurrentCell()) {
					symbol = " A ";
				}
				else if (j == 0 && cell.getLeft() == CellComponents.EXIT) {
					symbol = " E ";
				}
				else {
					symbol = " S ";
				}
				System.out.printf("%-2s", symbol);
			}
			System.out.println();
		}
	}
}
