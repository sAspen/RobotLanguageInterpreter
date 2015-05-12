
public class Backward extends Move {
	
	public Backward(Exp exp) {
		super(exp);
	}

	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		getExp().interpret();
		
		getGrid_Global().move(getExp().getValue(), 2);
	}
	
	@Override
	public String toString() {
		return "backward(" + getExp() + ")";
	}
}
