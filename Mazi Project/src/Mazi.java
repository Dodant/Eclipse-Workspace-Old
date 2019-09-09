import java.util.*;

public class Mazi {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Interpreter interpret = new Interpreter();
		interpret.repl(scanner);
	}
}

class Interpreter {
	public static double evalOperand(HashMap<String, Double> env, String operand) {
		Double result = 0.0;
		if (Character.isLetter(operand.charAt(0))) { // operand is a variable
			Double d = env.get(operand);
			if (d == null) {
				System.err.println("Undefined variable: " + operand);
			} else {
				result = d;
			}
		} else if (Character.isDigit(operand.charAt(0))) { // operand is a number
			result = new Double(operand);
		} else {
			System.err.println("Wrong Input: " + operand);
		}
		return result;
	}

	public static double evalExpr(double operand1, String operator, double operand2) {
		double result = 0;
		switch (operator.charAt(0)) {
		case '+':
			result = operand1 + operand2;
			System.out.println("[DEBUG]" + "\t" + operand1 + " + " + operand2 + " = " + result);
			break;
		case '-':
			result = operand1 - operand2;
			System.out.println("[DEBUG]" + "\t" + operand1 + " - " + operand2 + " = " + result);
			break;
		case '*':
			result = operand1 * operand2;
			System.out.println("[DEBUG]" + "\t" + operand1 + " * " + operand2 + " = " + result);
			break;
		case '/':
			result = operand1 / operand2;
			System.out.println("[DEBUG]" + "\t" + operand1 + " / " + operand2 + " = " + result);
			break;
		case '%':
			result = operand1 % operand2;
			System.out.println("[DEBUG]" + "\t" + operand1 + " % " + operand2 + " = " + result);
			break;
		default:
			System.err.println("Unsupported operator: " + operator);
		}
		return result;
	}

	public static double evalExpr(HashMap<String, Double> env, double operand1, String operator1, StringTokenizer stz) {
		double result = 0;
		if (stz.countTokens() == 0) {
			System.err.println("Tokens not available.");
		} else if (stz.countTokens() == 1) {
			String token = stz.nextToken();
			double operand2 = evalOperand(env, token);
			result = evalExpr(operand1, operator1, operand2);
		} else if (stz.countTokens() >= 3) {
			String tokenOperand2 = stz.nextToken();
			double operand2 = evalOperand(env, tokenOperand2);
			String operator2 = stz.nextToken();
			if (precedence(operator1) > precedence(operator2)) {
				double d = evalExpr(operand1, operator1, operand2);
				result = evalExpr(env, d, operator2, stz);
			} else if (precedence(operator1) < precedence(operator2)) {
				double d = evalExpr(env, operand2, operator2, stz);
				result = evalExpr(operand1, operator1, d);
			} else {
				if (associativity(operator1) == Associativity.LeftToRight) {
					double d = evalExpr(operand1, operator1, operand2);
					result = evalExpr(env, d, operator2, stz);
				} else { // Associativity.RightToLeft
					double d = evalExpr(env, operand2, operator2, stz);
					result = evalExpr(operand1, operator1, d);
				}
			}
		} else {
			System.err.println("Something wrong:");
			while (stz.hasMoreTokens()) {
				System.err.print(stz.nextToken() + " ");
			}
			System.err.println();
		}
		return result;
	}

	public static int precedence(String operator) {
		switch (operator.charAt(0)) {
		case '*':
		case '/':
		case '%':
			return 4;
		case '+':
		case '-':
			return 2;
		case '=':
			return 1;
		default:
			System.err.println("Unsupported operator: " + operator);
			return 0;
		}
	}

	enum Associativity {
		LeftToRight, RightToLeft;
	}

	public static Associativity associativity(String operator) {
		switch (operator.charAt(0)) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '%':
			return Associativity.LeftToRight; // Left to Right
		case '=':
			return Associativity.RightToLeft;
		default:
			System.err.println("Unsupported operator: " + operator);
			return Associativity.LeftToRight;
		}
	}

	public static void repl(Scanner scanner) {
		HashMap<String, Double> env = new HashMap<String, Double>();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			StringTokenizer stz = new StringTokenizer(line);
			if (stz.countTokens() > 0) {
				evalStmt(env, stz);
			}
		}	
	}

	public static void evalStmt(HashMap<String, Double> env, StringTokenizer stz) {
		String firstToken = stz.nextToken();
		String secondToken = stz.nextToken();
		if (secondToken.equals(new String("="))) {
			env.put(firstToken, evalExpr(env, 0, "+", stz));
		} else if (firstToken.equals(new String("READ"))) {
			Scanner scan = new Scanner(System.in);
			env.put(secondToken, scan.nextDouble());
		} else if (firstToken.equals(new String("PRINT"))) {
			if (stz.countTokens() != 0) {
				System.out.println(evalExpr(env, evalOperand(env, secondToken), stz.nextToken(), stz));
			} else {
				if(env.get(secondToken) != null) {
					double x = env.get(secondToken);
					System.out.println(x);
				} else {
					System.out.println("Undefined Variables: " + secondToken);
				}
			}
		} else
			System.err.println("Wrong Statement");
	}
}