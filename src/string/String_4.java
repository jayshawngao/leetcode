package string;

// 在单词间做逆序调整
public class String_4 {

	// 将字符串所有字符逆序
	public String help(String s){
		StringBuilder sb = new StringBuilder();
		for(int i =s.length()-1;i>=0;i--)
			sb.append(s.charAt(i));
		return sb.toString();
	}
	
	public String reverse(String s){
		s = help(s);
		String[] arrS = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arrS.length;i++){
			sb.append(help(arrS[i])+" ");
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args) {
		System.out.println(new String_4().reverse("pig loves dog"));
	}

}
