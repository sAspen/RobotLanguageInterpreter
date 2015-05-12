public class VarDecl implements Robol {
	
	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private Identifier identifier;
	private Exp exp;
	
	/**
	 * Pointer to the local system environment.
	 */
	private Robot env;
	
	public VarDecl(Identifier identifier, Exp exp) {
		this.identifier = identifier;
		this.exp = exp;
		
		env = null;
	}
	
	public void setEnv(Robot env) {
		this.env = env;
		identifier.setEnv(env);
	}


	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */ 
	@Override
	public void interpret() {
		exp.interpret();
		
		if (!env.newVariable(identifier.getName(), exp.getValue())) {
			System.err.println("Error: duplicate variable decleration (" + this + ")");
			System.exit(0);
		}
		
		prettyPrint();
	}
	
	@Override
	public String toString() {
		return "var " + identifier + " = " + exp;
	}
	
	public void prettyPrint() {
		System.out.println(this);
	}
}
