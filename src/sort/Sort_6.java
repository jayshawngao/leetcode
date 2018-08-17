package sort;

public class Sort_6 {

	public int needSort(int[] a){
		int leftNeedSort = a.length;
		int rightNeedSort = -1;
		int lefMax = Integer.MIN_VALUE;
		int rightMin = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (lefMax > a[i]) {
				rightNeedSort = i;
			}
			if (lefMax < a[i]) {
				lefMax = a[i];
			}
		}
		for (int i = a.length - 1; i >= 0; i--) {
			if (rightMin < a[i]) {
				leftNeedSort = i;
			}
			if (rightMin > a[i]) {
				rightMin = a[i];
			}
		}
		return rightNeedSort - leftNeedSort + 1;
	}
	public static void main(String[] args) {
		int[] a = new int[]{1,5,4,3,2,6,7};
		System.out.println(new Sort_6().needSort(a));
	}
}
