package string;


//判断两个字符串是否互为变形词
public class String_2 {
	
	public boolean judge(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		int[] a1 = new int[65536];
		int[] a2 = new int[65536]; //使用固定长度的数组代替HashMap
		for(int i=0;i<s1.length();i++){
			a1[s1.charAt(i)]++;
			a2[s2.charAt(i)]++;
		}
		for(int i=0;i<65536;i++){
			if(a1[i]!=a2[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1="a中文bbb";
		String s2="文中bab";
		System.out.println(new String_2().judge(s1, s2));
	}

}
