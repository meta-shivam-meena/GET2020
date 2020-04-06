import java.util.HashMap;

public class ExpressionEvaluator {
	private static HashMap<String, Integer> operatorPriority;
	
	static {
		operatorPriority.put("||", 1);
		operatorPriority.put("&&", 2);
		operatorPriority.put("==", 3);
		operatorPriority.put("!=", 3);
		operatorPriority.put("<", 4);
		operatorPriority.put(">", 4);
		operatorPriority.put("<=", 4);
		operatorPriority.put(">=", 4);
		operatorPriority.put("+", 1);
		operatorPriority.put("-", 1);
		operatorPriority.put("*", 1);
		operatorPriority.put("/", 1);
	}
}
