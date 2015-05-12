public class Assignment extends Stmt {
	
	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private Identifier identifier; 
	private Exp exp;
	
	/**
	 * Pointer to the local system environment.
	 */
	private Robot env;
	
	public Assignment(Identifier identifier, Exp exp) {
		this.identifier = identifier;
		this.exp = exp;
		
		env = null;
	}

	public void setEnv(Robot env) {
		this.env = env;
		identifier.setEnv(env);
		exp.setEnv(env);
	}
	
	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		exp.interpret();
		
		if (!env.setVariableValue(identifier.getName(), exp.getValue())) {
			System.err.println("Error: variable not declared (" + identifier + ")");
			System.exit(0);
		}
	}
	
	@Override
	public String toString() {
		return identifier + " = " + exp;
	}
}
