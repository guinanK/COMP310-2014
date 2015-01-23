import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;

public class RPN {
	Stack<Integer> stack = new Stack<Integer>();
	
	Stack<Integer> evaluate(String expression){
		StringReader sr = new StringReader(expression);
		Scanner scanner = new Scanner(sr);
		while(scanner.hasNext()){
			System.out.println(scanner.next());
			String token = scanner.next();
			//check for +,-,/,*
			if(token.equals("+")){
				//take two items off the stack 
				//and place result onto stack
			}
			else if(token.equals("/")){
				
			}
			else if(token.equals("-")){
				
			}
			else if(token.equals("*")){
				
			}
			Integer.parseInt(token);
			//catch all case
			//put the integer on the stack
			
		}
		
		
		return stack;
	}
}
