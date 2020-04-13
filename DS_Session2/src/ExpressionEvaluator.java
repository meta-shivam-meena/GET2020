import java.util.HashMap;

public class ExpressionEvaluator {
	private  HashMap<String, Integer> operatorPriority;
	private StackImpl<Integer> operands;
	private StackImpl<String> operators;

	public ExpressionEvaluator() {
		operatorPriority = new HashMap<String, Integer>();
		operands = new StackImpl<Integer>();
		operators = new StackImpl<String>();
		setPriority();
	}

	public String evaluateExpression(String expression) {
		String expressionType = evaluateExpressionType(expression);
		String[] tokens = expression.split(" ");

		try {
			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].charAt(0) >= '0' && tokens[i].charAt(0) <= '9') {
					operands.push(Integer.parseInt(tokens[i]));
				} else if (tokens[i].equals("!")) {
					i++;
					if (tokens[i].equals("0")) {
						operands.push(1);
					} else {
						operands.push(0);
					}
				} else if (tokens[i].equals("(")) {
					operators.push("(");
				} else if (tokens[i].equals(")")) {
					while (!operators.peek().equals(")")) {
						if (!process()) {
							throw new Exception();
						}
					}
					operators.pop();
				} else {
					while (!operators.isEmpty()
							&& operatorPriority.get(tokens[i]) < operatorPriority
									.get(operators.peek())) {
						if (!process()) {
							throw new Exception();
						}
					}
					operators.push(tokens[i]);
				}
			}
			
			while (!operators.isEmpty()) {
				if (!process()) {
					throw new Exception();
				}
			}
			
			int result = (int) operands.pop();
			if (expressionType.equals("Integer")) {
				return String.valueOf(result);
			} else {
				return result == 0 ? "false" : "true";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	private void setPriority() {
		operatorPriority.put("||", 1);
		operatorPriority.put("&&", 2);
		operatorPriority.put("==", 3);
		operatorPriority.put("!=", 3);
		operatorPriority.put("<", 4);
		operatorPriority.put(">", 4);
		operatorPriority.put("<=", 4);
		operatorPriority.put(">=", 4);
		operatorPriority.put("+", 5);
		operatorPriority.put("-", 5);
		operatorPriority.put("*", 6);
		operatorPriority.put("/", 6);
		operatorPriority.put("!", 7);
	}

	private String evaluateExpressionType(String expression) {
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '|' || ch == '&' || ch == '=' || ch == '!' || ch == '>'
					|| ch == '<') {
				return "Boolean";
			}
		}
		return "Integer";
	}

	private boolean process() {
		try {
			int operand2 = (int) operands.pop();
			int operand1 = (int) operands.pop();
			String operator = (String) operators.pop();
			int output = processSimpleExpression(operand1, operand2, operator);
			operands.push(output);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static Integer processSimpleExpression(int operand1, int operand2,
			String operator) {
		switch (operator) {
		case "||":
			if (operand1 != 0 || operand2 != 0) {
				return 1;
			} else {
				return 0;
			}
		case "&&":
			if (operand1 == 0 || operand2 == 0) {
				return 0;
			} else {
				return 1;
			}
		case "==":
			return operand1 == operand2 ? 1 : 0;
		case "!=":
			return operand1 != operand2 ? 1 : 0;
		case "<":
			return operand1 < operand2 ? 1 : 0;
		case ">":
			return operand1 > operand2 ? 1 : 0;
		case "<=":
			return operand1 <= operand2 ? 1 : 0;
		case ">=":
			return operand1 >= operand2 ? 1 : 0;
		case "+":
			return operand1 + operand2;
		case "-":
			return operand1 - operand2;
		case "*":
			return operand1 * operand2;
		case "/":
			return operand1 / operand2;
		default:
			return null;
		}
	}

	public static void main(String[] args) {
		ExpressionEvaluator evaluator = new ExpressionEvaluator();
		System.out.println(evaluator.evaluateExpression("4 * 5 == 2 * 13 - 6"));
	}
}
