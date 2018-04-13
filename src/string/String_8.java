package string;

// 判断括号是否合法
// 还有一种解法是使用栈
public class String_8 {

	public boolean judge(String s){
		int num = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='(') num++;
			else num--;
			if(num<0) return false;
		}
		return num==0;
	}
	
	public static void main(String[] args) {
		System.out.println(new String_8().judge("(()(()()))"));
	}
}
