package stackAndQueue;

import java.util.Stack;

public class Saq_3 {

	public Integer getLast(Stack<Integer> stack){
		int last = stack.pop();
		if(stack.isEmpty()) return last;
		else{
			int last2 = getLast(stack);
			stack.push(last);
			return last2;
		}
	}
	
	public void reverse(Stack<Integer> stack){
		if(stack.isEmpty()) return;
		int last = getLast(stack);
		reverse(stack);
		stack.push(last);
	}
	
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		new Saq_3().reverse(stack);
		System.out.println(stack);
	}
}
