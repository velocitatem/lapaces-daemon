package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
class Operation {
	private String operator, left, right, whole;
	private Operation opL, opR;

	public Operation(String operator, String left, String right) {
		super();
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Operation [operator=" + operator + ", left=" + left + ", right=" + right + ", whole=" + whole + ", opL="
				+ opL + ", opR=" + opR + "]";
	}

	public String getWhole() {
		return whole;
	}

	public void setWhole(String whole) {
		this.whole = whole;
	}

	public Operation getOpL() {
		return opL;
	}

	public void setOpL(Operation opL) {
		this.opL = opL;
	}

	public Operation getOpR() {
		return opR;
	}

	public void setOpR(Operation opR) {
		this.opR = opR;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

}

/**
 * The Class SymbolicDiffTest.
 */
class SymbolicDiffTest {

	/**
	 * Checks if is operator.
	 *
	 * @param in the in
	 * @return true, if is operator
	 */
	boolean isOperator(String in) {
		return Arrays.asList(operators).contains(in);
	}

	/** The operators. */
	String[] operators = { "+", "-", "*", "/", "^" };

	/**
	 * Eval stack.
	 *
	 * @param stack the stack
	 * @return the operation
	 */
	Operation evalStack(List<String> stack) {
		for (int i = 0; i < stack.size(); i += 1) {
			String o = stack.get(i);
			if (isOperator(o)) {
				String left = "", right = "";
				for (int l = 0; l < i; l += 1) {
					left += stack.get(l);
				}
				for (int r = i + 1; r < stack.size(); r += 1) {
					right += stack.get(r);
				}
				Operation op = new Operation(o, left, right);
				List<String> leftL = Arrays.asList(op.getLeft().split("")),
						rightL = Arrays.asList(op.getRight().split(""));
				op.setOpR(evalStack(rightL));
				op.setOpL(evalStack(leftL));
				System.out.println(op);
				return op;
			}

		}
		return null;
	}

	/**
	 * Compute.
	 *
	 * @param op the op
	 * @return the double
	 */
	double compute(Operation op) {
		if (op == null)
			return 0;
		System.out.println(op + " - " + x);
		double a = 0, b = 0, r = 0;
		if (op.getOpL() == null) {
			if (op.getLeft().equals("x")) {
				a = x;
			} else {
				a = Double.valueOf(op.getLeft());
			}
		} else {
			a = compute(op.getOpL());
		}
		if (op.getOpR() == null) {
			if (op.getRight().equals("x")) {
				b = x;
			} else {
				b = Double.valueOf(op.getRight());
			}
		} else {
			b = compute(op.getOpR());
		}
		switch (op.getOperator()) {
		case "*":
			r = a * b;
			break;
		case "^":
			r = Math.pow(a, b);
			break;
		case "/":
			r = a / b;
			break;
		}
		System.out.println(a + "" + op.getOperator() + b + "=" + r);

		return r;
	}

	/** The x. */
	double x = 3.5;

	/**
	 * Test.
	 */
	@Test
	void test() {

		String input = "2*x^4/2";
		String[] inputSplit = input.split("");
		List<String> stack = Arrays.asList(inputSplit);
		Operation opr = evalStack(stack);
		double x, r;
		x = compute(opr);
		System.out.println(x);
	}

}
