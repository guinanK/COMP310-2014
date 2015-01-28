import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;


public class RPN {
	Stack<Integer> stack = new Stack<Integer>();
	
	Stack<Integer> evaluate(String expression) {
		StringReader sr = new StringReader(expression);
		Scanner scanner = new Scanner(sr);
		
		while (scanner.hasNext()) {
			String token = scanner.next();
			try{
			// initial try case
			// put the integer on the stack
			Integer num = Integer.parseInt(token);
			stack.push(num);			
			}
			catch(NumberFormatException e){
			int result = 0;
			Integer int1 = stack.pop();
			Integer int2 = stack.pop();
			// Check for +, -, /, *
			if (token.equals("+")) {
				result = int2 + int1;
			}
			else if(token.equals("-")){
				result = int2 - int1;
			}
			else if(token.equals("*")){
				result = int2 * int1;
			}
			else if(token.equals("/")){
				result = int2 / int1;
			}
			stack.push(result);
			}
		}
		
		return stack;
	}
	void clear() {
		stack.clear();
	}
}
