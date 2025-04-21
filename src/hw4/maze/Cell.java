package hw4.maze;

public class Cell {
	

	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	
	/**
	 * This is the cell constructor. It creates a cell by passing the passed parameters
	 * and applying them using setter functions instead of this.direction for example, which is a safer way of creating 
	 * the cell and avoiding errors since the parameters are ran through null checks and set to default values.
	 * @param left: The left component of the cell.
	 * @param right: The right component of the cell.
	 * @param up: The upper component of the cell.
	 * @param down: The bottom component of the cell.
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		super();
		setLeft(left);
		setRight(right);
		setUp(up);
		setDown(down);
	}
	
	/**
	 * Returns the left component of the cell.
	 * @return: The left component of the cell.
	 */
	public CellComponents getLeft() {
		return left;
	}
	
	/**
	 * This method sets the left component of a cell, but it does a null check. In the testSetXWithNullCellComponent
	 * test methods, the default CellComponent when passed a null is WALL, which is why it is set if a null is passed.
	 * @param left: The passed left CellComponent. 
	 */
	public void setLeft(CellComponents left) {
		this.left = left;
		if (left == null) {
			this.left = CellComponents.WALL;
		}
	}

	/**
	 * Returns the right component of the cell.
	 * @return: The right component of the cell.
	 */
	public CellComponents getRight() {
		return right;
	}

	/**
	 * Sets the right component of the cell, if passed null it is set to WALL.
	 * @param right: The passed right CellComponent. 
	 */
	public void setRight(CellComponents right) {
		this.right = right;
		if (right == null) {
			this.right = CellComponents.WALL;
		}
	}

	/**
	 * Returns the right component of the cell.
	 * @return: The upper component of the cell.
	 */
	public CellComponents getUp() {
		return up;
	}

	/**
	 * Sets the upper component of the cell, if passed null it is set to WALL.
	 * @param up: The passed upper CellComponent.
	 */
	public void setUp(CellComponents up) {
		this.up = up;
		if (up == null) {
			this.up = CellComponents.WALL;
		}
	}

	/**
	 * Returns the lower component of the cell.
	 * @return: The lower component of the cell.
	 */
	public CellComponents getDown() {
		return down;
	}

	/**
	 * Sets the lower component of the cell, if passed null it is set to WALL.
	 * @param down: The passed lower CellComponent.
	 */
	public void setDown(CellComponents down) {
		this.down = down;
		if (down == null) {
			this.down = CellComponents.WALL;
		}
	}

	/**
	 * Returns the different components of the cell in a string.
	 */
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
	
	
	
	
	
	
	
	

}
