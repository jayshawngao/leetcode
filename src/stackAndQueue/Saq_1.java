package stackAndQueue;

import java.util.Stack;

// 实现一个特殊栈, 增加一个功能可以返回当前栈中的最小值
public class Saq_1<T extends Comparable<T>> {

	private Stack<T> stack1;
	private Stack<T> stack2;
	
	public Saq_1() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();// 存最小值
	}
	
	public T pop(){
		if(!stack2.isEmpty()&&stack2.peek()==stack1.peek()){// 当前弹出数等于stack2栈顶时，才从stack2中弹出该数
			stack2.pop();
		}
		return stack1.pop();
	}
	public T push(T item){
		if(stack2.isEmpty()||item.compareTo(stack2.peek())<=0){// 当item小于等于stack2栈顶时才推入
			stack2.push(item);
		}
		return stack1.push(item);
	}
	
	public T getMin(){
		return stack2.peek();
	}
	
	public static void main(String[] args) {
		Saq_1<Integer> myStack = new Saq_1<>();
		myStack.push(4);
		myStack.push(3);
		myStack.push(5);
		myStack.push(2);
		myStack.push(1);
		System.out.println(myStack.getMin());
		myStack.pop();
		System.out.println(myStack.getMin());
		myStack.pop();
		System.out.println(myStack.getMin());
		myStack.pop();
		System.out.println(myStack.getMin());
		myStack.pop();
		System.out.println(myStack.getMin());
		myStack.pop();
		
		
	}
}
