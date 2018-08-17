package sort;

import java.util.Arrays;

public class Sort_3 {

    public void sort(int[] a, int[] b) {
        int i = a.length - 1 - b.length; // a中实际的元素
        int j = b.length - 1;
        int k = a.length - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] >= b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }
        while (j >= 0) {
            a[k--] = b[j--];
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 7, 8, 9, 10, 0, 0, 0, 0, 0};
        int[] b = new int[]{1, 2, 3, 4, 5};
        new Sort_3().sort(a, b);
        System.out.println(Arrays.toString(a));
    }
}
