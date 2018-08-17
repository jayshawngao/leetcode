package stackAndQueue;

import java.util.Stack;

// 使用两个Stack模拟Queue
public class Saq_2<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;
	public Saq_2() {
		stack1 = new Stack<>(); //用于入队
		stack2 = new Stack<>(); //用于出队
	}
	
	public void offer(T item){
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		stack1.push(item);
	}
	
	public T peek(){
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.peek();
	}
	
	public T pop(){
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		Saq_2<Integer> myQueue = new Saq_2<>();
		myQueue.offer(1);
		myQueue.offer(2);
		myQueue.offer(3);
		System.out.println(myQueue.peek()); //1
		System.out.println(myQueue.pop());  //1
		myQueue.offer(4);
		System.out.println(myQueue.pop());  //2
	}
	
}
