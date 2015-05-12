public abstract class Exp implements Robol {
	
	/**
	 * Subnode in the abstract syntax tree.
	 */
	private int value;
	
	/**
	 * Pointer to the local system environment.
	 */
	private Robot env;
	
	public Exp() {
		env = null;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int newValue) {
		value = newValue;
	}
	
	public void setEnv(Robot env) {
		this.env = env;
	}
	
	public Robot getEnv() {
		return env;
	}
	
	@Override
	public void interpret() {
	}
}
