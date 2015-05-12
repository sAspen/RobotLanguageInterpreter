
public class Stop extends Stmt {

	/**
	 * Pointer to the ROBOL system environment.
	 */
	private Grid grid_Global;
	
	public Stop() {
	}
	
	public void setGrid_Global(Grid grid_ins) {
		grid_Global = grid_ins;
	}

	@Override
	public void interpret() {
		System.out.println("**************************************\n" +
				"The result is " + grid_Global.stateToString());
		System.exit(0);
	}
	
	@Override
	public String toString() {
		return "stop";
	}
}
