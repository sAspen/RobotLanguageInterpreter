
public class Identifier extends Exp {

	/**
	 * Subnode in the abstract syntax tree.
	 */
	private String name;
	
	public Identifier(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * Gets the value of the declared variable of this identifier
	 * 
	 * @return the value of the variable
	 */
	@Override 
	public int getValue() {
		if (!getEnv().isVariableDeclared(name)) {
			System.err.println("Error: variable not declared (" + name + ")");
			System.exit(0);
		}
		
		return getEnv().getVariableValue(name);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
