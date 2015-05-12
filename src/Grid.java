
public class Grid implements Robol {
	
	/**
	 * Subnode in the abstract syntax tree.
	 */
	private Size size_Global;
	
	
	/**
	 * System variables of a ROBOL program.
	 */
	private int x_pos, y_pos;
	private int direction;

	public Grid() {
		size_Global = new Size();
	}

	public Grid(Size size) {
		size_Global = size;
	}
	
	/**
	 * Checks if the given coordinates are outside the grid.
	 */
	public void checkOutOfBounds(int x, int y) {
		if (x_pos >= size_Global.getX_bound_global() || y_pos >= size_Global.getY_bound_global()) {
			System.err.println("Error: out of bounds (x = " + x_pos + ", y = " + y_pos + 
					", x_bound = " + size_Global.getX_bound_global() + ", y_bound = " + size_Global.getY_bound_global() + ")");
			System.exit(0);
		}
	}
	
	/**
	 * Sets the start position and direction of the robot on the grid.
	 * 
	 * @param x starting x coordinate
	 * @param y starting y coordinate
	 * @param direction starting direction
	 */
	public void startPos(int x, int y, int direction) {
		checkOutOfBounds(x, y);
		
		x_pos = x;
		y_pos = y;
		this.direction = direction;
	}

	
	/**
	 * Changes the direction of the robot to the given relative direction.
	 * 
	 * @param changeInDirection the relative direction i.e. how many times the robot shall turn left
	 */
	public void changeDirection(int changeInDirection) {
		direction = direction + changeInDirection;
		if (direction < 0) 
			direction += Direction.validStringKeys.length;
		else if (direction >= Direction.validStringKeys.length) 
			direction %= Direction.validStringKeys.length;
	}
	
	/**
	 * Moves the robot a distance on the grid in a given relative direction.
	 * 
	 * @param distance the distance
	 * @param changeInDirection the relative direction
	 */
	public void move(int distance, int changeInDirection) {
		changeDirection(changeInDirection);

		int x = x_pos, y = y_pos;
		
		/** 
		 * Calculate the new coordinates on the grid. 
		 */
		switch (direction) {
		case 0:
			x += distance;
			break;
		case 1:
			y += distance;
			break;
		case 2:
			x -= distance;
			break;
		case 3:
			y -= distance;
			break;
		default: 
			System.err.println("Error: move(" + distance + ", " + changeInDirection + ")");
			System.exit(0);
		}
		
		checkOutOfBounds(x, y);
		
		x_pos = x;
		y_pos = y;
	}
	
	public String stateToString() {
		return "(" + x_pos + "," + y_pos + "," + Direction.keyToStringKey(direction) + ")";
	}
	
	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		size_Global.interpret();
	}
	
	@Override
	public String toString() {
		return size_Global.toString();
	}
}
