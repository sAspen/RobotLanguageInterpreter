
public class TestProgram3 {

	public static void main(String[] args) {
		Program p = new Program();
		
		/**************************************
		Testing Code 3: Example with While loop
		size(64*64)
		var i = 5
		var j = 3
		start(23,6, -x)
		forward(3*i)
		down
		right(15)
		left(4)
		up
		backward(2*i + 3*j + 5)
		while(j>0)
		{
		right(j)
		j = j -1
		}
		stop
		**************************************
		The result is (26,19,y) */
		p.addGrid(new Grid(new Size(new Number(64), new Number(64))));
		p.addVarDecl(new VarDecl(new Identifier("i"), new Number(5)));
		p.addVarDecl(new VarDecl(new Identifier("j"), new Number(3)));
		p.addStmt(new Start(new Number(23), new Number(6), new Direction("-x")));
		p.addStmt(new Forward(new PlusExp(new Number(3), new Identifier("i"), '*')));
		p.addStmt(new PenDown());
		p.addStmt(new Right(new Number(15)));
		p.addStmt(new Left(new Number(4)));
		p.addStmt(new PenUp());
		p.addStmt(new Backward(new PlusExp(new PlusExp(new PlusExp(new Number(2), new Identifier("i"), '*'), 
				new PlusExp(new Number(3), new Identifier("j"), '*'), '+'), new Number(5), '+')));
		While w = new While(new BooleanExp(new Identifier("j"), new Number(0), '>'));
		p.addStmt(w);
		w.addStmt(new Right(new Identifier("j")));
		w.addStmt(new Assignment(new Identifier("j"), new PlusExp(new Identifier("j"), new Number(1), '-')));
		p.addStmt(new Stop());
		
		p.interpret();
	}

}
