
public abstract class Move extends Stmt {

	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private Exp exp;

	/**
	 * Pointer to the ROBOL system environment.
	 */
	private Grid grid_Global;
	
	public Move() {
		exp = new Number(0);
		
		grid_Global = null;
	}
	
	public Move(Exp exp) {
		this.exp = exp;
		
		grid_Global = null;
	}

	public Exp getExp() {
		return exp;
	}
	
	public void setGrid_Global(Grid grid_ins) {
		grid_Global = grid_ins;
	}
	
	public Grid getGrid_Global() {
		return grid_Global;
	}
	
	public void setEnv(Robot env) {
		exp.setEnv(env);
	}
}
