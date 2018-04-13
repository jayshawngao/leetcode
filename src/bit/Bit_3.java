package bit;

public class Bit_3 {

	public static int flip(int n){
		return n^1;
	}
	
	// 原本 , (n>>31)&1 会根据正负数返回0或1,经过flip函数取反之后, 返回1或0 
	public static int sign(int n){
		return flip((n>>31)&1);
	}

	// 返回a和b中较大的那个数
	public static int getMax1(int a, int b){
		int c = a-b;
		int scA = sign(c); 
		int scB = flip(scA);
		return a*scA+b*scB; //如果a<b, 那么scA==0, scB==1
	} 
	
	public static int getMax2(int a, int b){
		int as = sign(a);  // 等于1表示非负数, 等于0表示负数
		int bs = sign(b);
		int cs = sign(a-b);
		int difab = as^bs;
		int samab = flip(difab);
		int returnA = difab*as + samab*cs;
		int returnB = flip(returnA);
		return a*returnA+b*returnB;
	}
	
	public static void main(String[] args) {
		System.out.println(getMax2(1999999999,-1999999999));
	}
}
