package binarySearch;

public class BinarySearch_3 {

	// 返回数组中的最小值
	public int min(int[] a){
		int left = 0;
		int right = a.length-1;
		if(a[left]<a[right]) return a[left];
		while(left<=right){
			if(a[left]<=a[right]){ // 注意是小于等于, 等于的情况是L和R都在同一个位置上
				System.out.println("返回自while");
				return a[left];
			}
			int mid = left+(right-left)/2;
			if(a[left]>a[mid]) right = mid;
			else if(a[mid]>a[right]) left = mid+1;
			// 此时通过二分搜索已经找不出, 只能使用while后的循环
			else break;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++){
			min = Math.min(min, a[i]);
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[] a =new int[]{9,1,2,3,4,5,6,7,8};
		System.out.println(new BinarySearch_3().min(a));
	}
}
