
public class Size implements Robol {

	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private int x_bound_global;
	private int y_bound_global;
	
	public Size(){
		x_bound_global = 0;
		y_bound_global = 0;
	}
	
	public Size(Number x_bound, Number y_bound) {
		x_bound_global = x_bound.getValue();
		y_bound_global = y_bound.getValue();
	}

	public int getX_bound_global() {
		return x_bound_global;
	}

	public int getY_bound_global() {
		return y_bound_global;
	}

	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		prettyPrint();
	}

	@Override
	public String toString() {
		return "size(" + x_bound_global + "*" + y_bound_global + ")";
	}

	
	public void prettyPrint() {
		System.out.println(this);
	}
}
