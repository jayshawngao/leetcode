package stackAndQueue;

import java.util.Stack;

public class Saq_4 {

	public void sortStack(Stack<Integer> stack){
		Stack<Integer> help = new Stack<>();
		while(!stack.isEmpty()){
			int temp = stack.pop(); 
			// 如果temp小于等于help的栈顶
			if(help.isEmpty()||help.peek()>=temp){
				help.push(temp); // 直接入help
			}else{
				// 否则把help倒入stack, 再将temp入help
				while(!help.isEmpty()){
					stack.push(help.pop());
				}
				help.push(temp);
			}
		}
		while(!help.isEmpty()){
			// help倒回stack
			stack.push(help.pop());
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(4);
		new Saq_4().sortStack(stack);
		System.out.println(stack);
	}
}
