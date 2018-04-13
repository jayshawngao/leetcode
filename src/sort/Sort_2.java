package sort;

import java.util.Arrays;

public class Sort_2 {

	public void buildHeap(int[] a) {
		for (int i = (a.length - 2) / 2; i >= 0; i--) {
			adjust(a, i, a.length);
		}
	}

	public void adjust(int[] a, int p, int length) {
		int temp = a[p];
		for (int i = 2 * p + 1; i < length; i = 2 * i + 1) {
			if ((i + 1) < length && a[i + 1] > a[i]) {
				i++;
			}
			if (temp > a[i])
				break;
			a[p] = a[i];
			p = i;
		}
		a[p] = temp;
	}

	public void heapSort(int[] a) {
		buildHeap(a);
		for (int i = a.length - 1; i >= 1; i--) {
			swap(a, 0, i);
			adjust(a, 0, i);
		}
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public boolean checkDuplication(int[] a) {
		heapSort(a);
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] == a[i + 1])
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 6, 7, 4, 3, 1, 2, 8, 5, 4 };
		System.out.println(new Sort_2().checkDuplication(a));
	}
}
