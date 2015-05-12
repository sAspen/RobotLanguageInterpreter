import java.util.ArrayList;
import java.util.TreeMap;


public class Robot implements Robol {
	
	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private ArrayList<VarDecl> varDecls;
	private ArrayList<Stmt> stmts;
	
	/**
	 * Map of variables declared at runtime
	 */
	private TreeMap<String, Integer> variables_Env;
	
	public Robot() {
		varDecls = new ArrayList<VarDecl>();
		stmts = new ArrayList<Stmt>();
		
		variables_Env = new TreeMap<String, Integer>();
	}

	/**
	 * Checks if a variable with the given identifier has been declared.
	 * 
	 * @param name the identifier
	 * @return true if it was declared, false otherwise
	 */
	public boolean isVariableDeclared(String name) {
		return variables_Env.containsKey(name);
	}
	
	/**
	 * Creates a new variable with the given identifier and initial value.
	 * 
	 * @param name the identifier of the new variable
	 * @param initalValue the initial value of the new variable
	 * @return true if there wasn't an already declared variable with the given identifier and the creation was successful, false otherwise
	 */
	public boolean newVariable(String name, int initalValue) {
		return !isVariableDeclared(name) && variables_Env.put(name, initalValue) == null;
	}
	
	/**
	 * Gets the value of a variable with the given identifier.
	 * 
	 * @param name the identifier of the variable
	 * @return the value of the variable
	 */
	public int getVariableValue(String name) {
		return variables_Env.get(name);
	}
	
	/**
	 * Sets the value of a declared variable.
	 * 
	 * @param name identifier of the variable
	 * @param newValue the value to be assigned to the variable
	 * @return true if the variable has been declared and the assignment was successful, false otherwise
	 */
	public boolean setVariableValue(String name, int newValue) {
		return isVariableDeclared(name) && variables_Env.put(name, newValue) != null;
	}
	
	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		for (VarDecl VD : varDecls) 
			VD.interpret();
		for (Stmt stmt : stmts) {
			stmt.prettyPrint();
			stmt.interpret();
		}
	}
	
	public void addVarDecl(VarDecl varDecl_ins) {
		varDecls.add(varDecl_ins);
		varDecl_ins.setEnv(this);
	}

	public void addStmt(Assignment stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setEnv(this);
	}
	
	public void addStmt(IfThenElse stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setEnv(this);
	}
	
	public void addStmt(Move stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setEnv(this);
	}

	public void addStmt(Start stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setEnv(this);
	}
	
	public void addStmt(While stmt_ins) {
		stmts.add(stmt_ins);
		stmt_ins.setEnv(this);
	}
	
	public void addStmt(Stmt stmt_ins) {
		stmts.add(stmt_ins);
	}
}
