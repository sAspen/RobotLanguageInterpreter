
public class Forward extends Move {
	
	public Forward(Exp exp) {
		super(exp);
	}

	/* (non-Javadoc)
	 * @see Robol#interpret()
	 */
	@Override
	public void interpret() {
		getExp().interpret();
		
		getGrid_Global().move(getExp().getValue(), 0);
	}
	
	@Override
	public String toString() {
		return "forward(" + getExp() + ")";
	}
}
