package bit;

public class Bit_2 {

	public void swap(int a, int b){
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		new Bit_2().swap(1, 2);
	}
}
