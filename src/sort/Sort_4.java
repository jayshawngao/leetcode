package sort;

import java.util.Arrays;

// 荷兰国旗问题
public class Sort_4 {

	public void sort(int[] a){
		int pos_0 = -1; //0区指针, 初始时指向数组前
		int pos_2 = a.length; //2区指针, 初始时指向数组后
		for(int i=0;i<pos_2;i++){ // pos_2是会变的, 所以循环在什么时候结束也是不确定的
			if(a[i]==0) swap(a, i, ++pos_0);
			else if(a[i]==2) {
				swap(a, i, --pos_2);
				i--; //i退回到当前位置, 因为从2区交换过来的数字没有经过检查
			}
		}
	}
	
	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{2,2,1,0,1,2,0,0,1,2,0,2,1,0};
		new Sort_4().sort(a);
		System.out.println(Arrays.toString(a));
	}
	
}
