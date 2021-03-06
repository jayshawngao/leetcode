package binarySearch;

public class BinarySearch_1 {

	// 返回任意一个局部最小位置
	public int localMin(int[] a) {
		if (a == null || a.length == 0)
			return -1;
		if (a.length == 1)
			return a[0];
		if (a[0] < a[1]) {
			return a[0];
		}
		if (a[a.length - 1] < a[a.length - 2]){
			return a[a.length - 1];
		}
		int left = 0;
		int right = a.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1])
				return mid;
			else if (a[mid] > a[mid - 1]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 14, 5, 7, 9, 11, 4, 13 };
		System.out.println(new BinarySearch_1().localMin(a));
	}
}
