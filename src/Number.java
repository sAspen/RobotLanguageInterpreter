

public class Number extends Exp {
	
	public Number() {
		setValue(0);
	}
	
	public Number(int value) {
		setValue(value);
	}
	
	@Override
	public String toString() {
		return Integer.toString(getValue());
	}
}
