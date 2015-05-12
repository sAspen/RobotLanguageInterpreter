
public class TestProgram1 {

	public static void main(String[] args) {
		Program p = new Program();
		
		/**************************************
		Testing Code 1: Simple Example
		size(64*64)
		start(23,30, -x)
		forward(15)
		down
		left(15)
		right(2+3)
		up
		backward(10 + 27)
		stop
		***************************************
		The result is (40,15,x) */
		p.addGrid(new Grid(new Size(new Number(64), new Number(64))));
		p.addStmt(new Start(new Number(23), new Number(30), new Direction("-x")));
		p.addStmt(new Forward(new Number(15)));
		p.addStmt(new PenDown());
		p.addStmt(new Left(new Number(15)));
		p.addStmt(new Right(new PlusExp(new Number(2), new Number(3), '+')));
		p.addStmt(new PenUp());
		p.addStmt(new Backward(new PlusExp(new Number(10), new Number(27), '+')));
		p.addStmt(new Stop());
		
		p.interpret();
	}

}
