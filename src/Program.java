public class Program implements Robol {
	
	
	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private Grid grid_Global;
	private Robot robot_Global;
	
	
	public Program() {
		grid_Global = new Grid();
		robot_Global = new Robot();
	}
	
	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		grid_Global.interpret();
		robot_Global.interpret();
	}

	public void addGrid(Grid grid_ins) {
		this.grid_Global = grid_ins;
	}
	
	public void addRobot(Robot robot_ins) { 
		this.robot_Global = robot_ins;
	}
	
	public void addVarDecl(VarDecl varDecl_ins) {
		robot_Global.addVarDecl(varDecl_ins);
	}

	public void addStmt(Start stmt_ins) {
		robot_Global.addStmt(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
	}
	
	public void addStmt(Move stmt_ins) {
		robot_Global.addStmt(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
	}
	
	public void addStmt(Stop stmt_ins) {
		robot_Global.addStmt(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
	}
	
	public void addStmt(IfThenElse stmt_ins) {
		robot_Global.addStmt(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
	}
	
	public void addStmt(While stmt_ins) {
		robot_Global.addStmt(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
	}
	
	public void addStmt(Stmt stmt_ins) {
		robot_Global.addStmt(stmt_ins);
	}
}
