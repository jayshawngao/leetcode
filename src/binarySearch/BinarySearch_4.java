package binarySearch;

public class BinarySearch_4 {

	// 返回数组中最左边满足a[i]==i的位置i, 如果不存在则返回-1
	public int find(int[] a){
		int res = -1;
		if(a[0]>0||a[a.length-1]<a.length-1) return res;
		int left = 0;
		int right = a.length-1;
		while(left<=right){
			int mid = left+(right-left)/2;
			if(a[mid]==mid){
				res = mid;
				right = mid-1;
			}else if(a[mid]>mid){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{-1,0,2,3,5,6,7,8};
		System.out.println(new BinarySearch_4().find(a));
	}
}
