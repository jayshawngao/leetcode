package sort;

import java.util.Arrays;

public class HeapSort2 {

	private static int K = 3; // 堆的大小
	private static int[] heap = new int[K]; //使用辅助数组做堆, 便于编码

	public void buildHeap(int[] a) {
		for (int i = 0; i < K; i++)
			heap[i] = a[i];
		for (int i = (K - 2) / 2; i >= 0; i--) {
			adjust(heap, i);
		}
	}

	public void adjust(int[] heap, int p) {
		int temp = heap[p];
		for (int i = 2 * p + 1; i <= (K - 1); i = 2 * i + 1) {
			if (i < (K - 1) && heap[i] > heap[i + 1]) {
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
		for (int i = K; i < a.length; i++) {
			a[i - K] = heap[0]; //弹出堆头
			heap[0] = a[i]; // 把①从堆中删除一个元素, ②在末尾加一个元素的操作 简化成了把堆头替换成新加入的元素
			adjust(heap, 0);
		}
		for (int i = 0; i < K; i++)
			a[a.length - 1 - i] = heap[K - 1 - i];

	}

	public static void main(String[] args) {
		K = 3;
		int[] a = new int[] { 50, 30, 60, 40, 80, 90, 70 };
		new HeapSort2().heapSort(a);
		System.out.println(Arrays.toString(a));
	}
}
