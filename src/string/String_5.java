package string;

public class String_5 {

	public String help(String s, int i, int j){
		StringBuilder sb = new StringBuilder();
		for(int k=j;k>=i;k--){
			sb.append(s.charAt(k));
		}
		return sb.toString();
	}
	
	public String reverse(String s, int i){
		StringBuilder sb = new StringBuilder();
		sb.append(help(s, 0, i));
		sb.append(help(s, i+1, s.length()-1));
		return help(sb.toString(), 0, sb.toString().length()-1);
	}
	
	public static void main(String[] args) {
		System.out.println(new String_5().reverse("ABCDE", 2));
	}
}
