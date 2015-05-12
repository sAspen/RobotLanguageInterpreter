import java.util.ArrayList;


public class IfThenElse extends Stmt {
	
	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private BooleanExp booleanExp; 
	private ArrayList<Stmt> thenStmts, elseStmts;
	
	/**
	 * Pointer to the ROBOL system environment.
	 */
	private Grid grid_Global;
	/**
	 * Pointer to the local system environment.
	 */
	private Robot env;
	
	public IfThenElse(BooleanExp booleanExp) {
		this.booleanExp = booleanExp;
		
		thenStmts = new ArrayList<Stmt>();
		elseStmts = new ArrayList<Stmt>();
		
		grid_Global = null;
		env = null;
	}

	public void setGrid_Global(Grid grid_ins) {
		grid_Global = grid_ins;
	}
	
	public void setEnv(Robot env) {
		this.env = env;
		booleanExp.setEnv(env);
	}

	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		booleanExp.interpret();
		
		if (BooleanExp.getBooleanValue(booleanExp)) {
			for (Stmt stmt : thenStmts)
				stmt.interpret();
		} else if (elseStmts != null) 
			for (Stmt stmt : elseStmts)
				stmt.interpret();
	}
	
	public void addThenStmt(Assignment stmt_ins) {
		thenStmts.add(stmt_ins);
		stmt_ins.setEnv(env);
	}
	
	public void addThenStmt(IfThenElse stmt_ins) {
		thenStmts.add(stmt_ins);
		stmt_ins.setEnv(env);
	}
	
	public void addThenStmt(Move stmt_ins) {
		thenStmts.add(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
		stmt_ins.setEnv(env);
	}

	public void addThenStmt(Start stmt_ins) {
		thenStmts.add(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
		stmt_ins.setEnv(env);
	}
	
	public void addThenStmt(Stop stmt_ins) {
		thenStmts.add(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
	}
	
	public void addThenStmt(While stmt_ins) {
		thenStmts.add(stmt_ins);
		stmt_ins.setEnv(env);
	}
	
	public void addThenStmt(Stmt stmt_ins) {
		thenStmts.add(stmt_ins);
	}
	
	public void addElseStmt(Assignment stmt_ins) {
		elseStmts.add(stmt_ins);
		stmt_ins.setEnv(env);
	}
	
	public void addElseStmt(IfThenElse stmt_ins) {
		elseStmts.add(stmt_ins);
		stmt_ins.setEnv(env);
	}
	
	public void addElseStmt(Move stmt_ins) {
		elseStmts.add(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
		stmt_ins.setEnv(env);
	}
	
	public void addElseStmt(Start stmt_ins) {
		elseStmts.add(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
		stmt_ins.setEnv(env);
	}
	
	public void addElseStmt(Stop stmt_ins) {
		elseStmts.add(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
	}
	
	public void addElseStmt(While stmt_ins) {
		elseStmts.add(stmt_ins);
		stmt_ins.setEnv(env);
	}
	
	public void addElseStmt(Stmt stmt_ins) {
		elseStmts.add(stmt_ins);
	}
	
	@Override
	public String toString() {
		String s = "if (" + booleanExp + ") {\n";
		for (Stmt stmt : thenStmts) 
			s += "\t" + stmt + "\n";
		if (elseStmts != null) {
			s += "} else {\n";
			for (Stmt stmt : elseStmts) 
				s += "\t" + stmt + "\n";
			s += "}";
		} else 
			s += "}";
		
		return s;
	}
}
