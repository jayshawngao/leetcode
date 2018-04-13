package stackAndQueue;

import java.util.Stack;

// 使用两个Stack模拟Queue
public class Saq_2<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;
	public Saq_2() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public void offer(T item){
		if(stack1.isEmpty()){
			while(!stack2.isEmpty()){
				T temp = stack2.pop();
				stack1.push(temp);
			}
		}
		stack1.push(item);
	}
	
	public T peek(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				T temp = stack1.pop();
				stack2.push(temp);
			}
		}
		return stack2.peek();
	}
	
	public T pop(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				T temp = stack1.pop();
				stack2.push(temp);
			}
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
