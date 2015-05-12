
public class Start extends Stmt {

	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private Exp exp1, exp2;
	private Direction direction;
	
	/**
	 * Pointer to the ROBOL system environment.
	 */
	private Grid grid_Global;
	
	public Start(Exp exp1, Exp exp2, Direction direction) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.direction = direction;
	}
	
	public void setGrid_Global(Grid grid_ins) {
		grid_Global = grid_ins;
	}
	
	public void setEnv(Robot env) {
		exp1.setEnv(env);
		exp2.setEnv(env);
	}
	
	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		exp1.interpret();
		exp2.interpret();
		direction.interpret();
		
		grid_Global.startPos(exp1.getValue(), exp2.getValue(), direction.getKey());
	}	
	
	@Override
	public String toString() {
		return "start(" + exp1 + "," + exp2 + "," + direction + ")";
	}
}
