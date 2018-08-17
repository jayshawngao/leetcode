package sort;

import java.util.Arrays;

public class Sort_1 {

	private static int STEP = 7; // 堆的大小
	private static int[] heap = new int[STEP]; //使用辅助数组做堆, 便于编码

	public void buildHeap(int[] a) {
		for (int i = 0; i < STEP; i++)
			heap[i] = a[i];
		for (int i = (STEP - 2) / 2; i >= 0; i--) {
			adjust(heap, i, STEP);
		}
	}

	public void adjust(int[] heap, int p, int len) {
		int temp = heap[p];
		for (int i = 2 * p + 1; i <= (len - 1); i = 2 * i + 1) {
			if (i < (len - 1) && heap[i] > heap[i + 1]) {
				i++;
			}
			if (temp <= heap[i]) {
				break;
			} else {
				heap[p] = heap[i];
				p = i;
			}
		}
		heap[p] = temp;
	}

	public void heapSort(int[] a) {
		buildHeap(a);
		for (int i = 0; i < a.length; i++) {
			a[i] = heap[0];
			if (i + STEP <= a.length - 1) {
				heap[0] = a[i + STEP];
				adjust(heap, 0, STEP);
			} else {
				swap(heap, 0, a.length - 1 - i);
				adjust(heap, 0, a.length - 1 - i);
			}
		}

	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 50, 30, 60, 40, 80, 90, 70 };
		new Sort_1().heapSort(a);
		System.out.println(Arrays.toString(a));
	}
}
