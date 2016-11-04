package neu.sxc.expression.syntax.function;

import neu.sxc.expression.syntax.ArgumentsMismatchException;
import neu.sxc.expression.tokens.DataType;
import neu.sxc.expression.tokens.Valuable;

public class Abs extends Function {

	public Abs() {
		super("abs", new DataType[]{DataType.NUMBER});
	}

	public int getArgumentNum() {
		return 1;
	}

	@Override
	protected Object executeFunction(Valuable[] arguments)
			throws ArgumentsMismatchException {
		Valuable argument = arguments[0];
		return argument.getNumberValue().abs();
	}

}
