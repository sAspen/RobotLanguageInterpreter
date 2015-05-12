
public class Left extends Move {
	
	public Left(Exp exp) {
		super(exp);
	}

	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		getExp().interpret();
		
		getGrid_Global().move(getExp().getValue(), 1);
	}
	
	@Override
	public String toString() {
		return "left(" + getExp() + ")";
	}
}