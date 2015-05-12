import java.util.ArrayList;


public class While extends Stmt {

	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private BooleanExp booleanExp;
	private ArrayList<Stmt> stmts;
	
	/**
	 * Pointer to the ROBOL system environment.
	 */
	private Grid grid_Global;
	/**
	 * Pointer to the local system environment. 
	 */
	private Robot env;
	
	public While(BooleanExp booleanExp) {
		this.booleanExp = booleanExp;
		stmts = new ArrayList<Stmt>();
		
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

	@Override
	public void interpret() {
		for (; ;) {
			booleanExp.interpret();
			if (!BooleanExp.getBooleanValue(booleanExp))
				break;
			for (Stmt stmt : stmts) 
				stmt.interpret();
		}
	}
	
	public void addStmt(Assignment stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setEnv(env);
	}
	
	public void addStmt(IfThenElse stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setEnv(env);
	}
	
	public void addStmt(While stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setEnv(env);
	}
	
	public void addStmt(Start stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
		stmt_ins.setEnv(env);
	}
	
	public void addStmt(Move stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
		stmt_ins.setEnv(env);
	}
	
	public void addStmt(Stop stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setGrid_Global(grid_Global);
	}
	
	public void addStmt(Stmt stmt_ins) {
		stmts.add(stmt_ins);
	}
	
	@Override
	public String toString() {
		String s = "while (" + booleanExp + ") {\n";
		for (Stmt stmt : stmts) 
			s += "\t" + stmt + "\n";
		s += "}";
		
		return s;
	}
}
