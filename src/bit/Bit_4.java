package bit;

public class Bit_4 {

	// 返回数组中唯一一个出现奇数次的元素
	public int findOdd(int[] a){
		int eo = 0;
		for(int i=0;i<a.length;i++){
			eo = eo^a[i];
		}
		return eo;
	}
	public static void main(String[] args) {
		System.out.println(new Bit_4().findOdd(new int[]{3,3,5,4,5}));
	}
}
