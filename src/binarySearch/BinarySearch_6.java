package binarySearch;

public class BinarySearch_6 {

	// 没有考虑溢出
	public int pow(int a, int b){
		String binary = Integer.toBinaryString(b);
		int res = 1;
		int base = a;
		for(int i=binary.length()-1;i>=0;i--){
			if(binary.charAt(i)=='1'){
				res *= base;
			}
			base *= base;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new BinarySearch_6().pow(10,5));
	}
}
