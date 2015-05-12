
public class BooleanExp extends Exp {

	/**
	 * Subnodes in the abstract syntax tree.
	 */
	private Exp exp1, exp2;
	private char operator;
	
	public BooleanExp(Exp exp1, Exp exp2, char operator) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.operator = operator;
	}
	
	public static boolean getBooleanValue(BooleanExp BE) {
		return BE.getValue() > 0;
	}
	
	public void setEnv(Robot env) {
		super.setEnv(env);
		exp1.setEnv(env);
		exp2.setEnv(env);
	}
	
	@Override
	public void interpret() {
		exp1.interpret();
		exp2.interpret();
		
		switch (operator) {
		case '<' : 
			setValue(exp1.getValue() < exp2.getValue() ? 1 : 0);
			break;
		case '>' : 
			setValue(exp1.getValue() > exp2.getValue() ? 1 : 0);
			break;
		case '=': 
			setValue(exp1.getValue() == exp2.getValue() ? 1 : 0);
			break;
		default:
			System.err.println("Error: invalid or unsupported boolean operator (" + operator + ")");
			System.exit(0);
		}
	}

	@Override
	public String toString() {
		return exp1 + " " + operator + " " + exp2;
	}
	
}
