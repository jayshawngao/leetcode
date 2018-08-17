package stackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

// 滑动窗口问题
public class Saq_5 {

    // 使用TreeMap实现
    public int[] max(int[] a, int win) {
        int[] b = new int[a.length - win + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 值->出现次数
        for (int i = 0; i < win; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        b[0] = map.lastKey();
        for (int i = 1; i < b.length; i++) {
            map.put(a[win - 1 + i], map.getOrDefault(a[win - 1 + i], 0) + 1);
            map.put(a[i - 1], map.getOrDefault(a[i - 1], 0) - 1);
            if (map.get(a[i - 1]) == 0) {
                map.remove(a[i - 1]);
            }
            b[i] = map.lastKey();
        }
        return b;
    }


    // 使用双端队列实现
    public int[] max3(int[] a, int win) {
        int[] b = new int[a.length - win +1];
        Deque<Integer> deque = new LinkedList<>(); // 存的是值而不是下标
        for (int i = 0; i < win; i++) {
            while (!deque.isEmpty() && deque.peekLast() < a[i]) {
                deque.pollLast();
            }
            deque.offerLast(a[i]);
        }
        b[0] = deque.peekFirst();
        for (int i = 1; i < b.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < a[win-1+i]) {
                deque.pollLast();
            }
            deque.offerLast(a[win-1+i]);
            if (deque.peekFirst() == a[i-1]) {
                deque.pollFirst();
            }
            b[i] = deque.peekFirst();
        }
        return b;
    }

    public static void main(String[] args) {
        int[] result = new Saq_5().max3(new int[]{1, 3, 4, 2, 2, 2}, 3);
        System.out.println(Arrays.toString(result));
    }

}
