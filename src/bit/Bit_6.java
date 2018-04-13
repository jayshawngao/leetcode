package bit;

public class Bit_6 {

	public static String encode(String text, String password){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<text.length();i++){
			int c = text.charAt(i);
			for(int j=0;j<password.length();j++){
				c = c^password.charAt(j); 
			}
			sb.append((char)c);
		}
		return sb.toString();
	}
	
	public static String decode(String cipher, String password){
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<cipher.length();i++){
			int c = cipher.charAt(i);
			for(int j=0;j<password.length();j++){
				c = c^password.charAt(j); 
			}
			sb.append((char)c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "hello world!";
		String password = "123456789";
		System.out.println(encode(s, password));
		System.out.println(decode(encode(s, password), password));
	}
}
