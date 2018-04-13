package sort;

import java.util.Arrays;

public class Sort {

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// 冒泡排序
	public void bubble(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j + 1, j);
				}
			}
		}
	}

	// 选择排序
	public void select(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(a, i, min);
		}
	}

	// 插入排序
	public void insert(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					swap(a, j - 1, j);
				} else
					break; // 如果没有发生交换, 说明已经找到正确的插入位置, 退出循环
			}
		}
	}

	// 归并排序
	private void merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		// 把较小的数先移到数组中
		while (i <= mid && j <= high) {
			if (a[i] <= a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		// 左边剩余的
		while (i <= mid)
			temp[k++] = a[i++];
		// 右边剩余的
		while (j <= high)
			temp[k++] = a[j++];
		// 覆盖原数组
		for (int k2 = 0; k2 < temp.length; k2++)
			a[k2 + low] = temp[k2];
	}

	// 归并排序
	public void sort(int[] a, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			// 对左边排序
			sort(a, low, mid);
			// 对右边排序
			sort(a, mid + 1, high);
			// 合并左右
			merge(a, low, mid, high);
		}
	}
	
	// 快速排序
	// 每次选择区间的最右一个数作为划分数, 免去了第一次交换
	public void quick(int[] a, int low, int high){
		if(low>=high) return;
		int i = low-1; //小于等于区间下标
		for(int j=low;j<high;j++){ //j<high, 因为a[high]是划分数, 需要等到最后进行调整
			if(a[j]<a[high]){ 
				swap(a, ++i, j); //只要小于划分数, 就和小于等于区间的下一个数进行交换
			}
		}
		swap(a, ++i, high);  // 此时i指向划分数
		quick(a, low, i-1);
		quick(a, i+1, high);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 7, 6, 5, 3, 4, 2, 1 };
		new Sort().quick(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

	}
}
