package binarySearch;

public class BinarySearch_2 {

	// 返回num出现的最左位置, 如果没有返回-1
	public int leftMost(int[] a, int num){
		int res = -1;
		int left = 0;
		int right = a.length-1;
		while(left<=right){
			int mid = left+(right-left)/2;
			if(a[mid]==num){
				res = mid;
				right = mid-1; //再往左边找更小的
			}else if(a[mid]>num){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,3,3,4,4,4,4,4,4,4,4};
		System.out.println(new BinarySearch_2().leftMost(a, 3));
	}
}
