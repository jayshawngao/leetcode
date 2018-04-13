package sort;

import java.util.Arrays;

public class Sort_3 {

	public void sort(int[] a, int[] b){
		int i = b.length-1;
		int j = a.length-1;
		int k = j-i-1;
		while(i>=0&&k>=0){
			if(a[k]>=b[i]){
				a[j--]=a[k--];
			}else 
				a[j--]=b[i--];
		}
		// 防止b中还有数据未拷贝到a中, 此时a中的数相对较大, 已经都转移到了后面
		while(i>=0){
			a[j--]=b[i--];
		}
		
	}
	public static void main(String[] args) {
		int[] a = new int[]{6,7,8,9,10,0,0,0,0,0};
		int[] b= new int[]{1,2,3,4,5};
		new Sort_3().sort(a, b);
		System.out.println(Arrays.toString(a));
	}
}
