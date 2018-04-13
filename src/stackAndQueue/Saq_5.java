package stackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

// 滑动窗口问题
public class Saq_5 {

	// 使用TreeMap实现
	public int[] max(int[] a, int win) {
		int[] b = new int[a.length - win + 1];
		TreeMap<Integer, Integer> map = new TreeMap<>(); // 键为数字, 值为出现的次数
		for (int i = 0; i < win; i++) {
			map.put(a[i], 1 + map.getOrDefault(a[i], 0)); // 首先, 计算0~win-1位置出现的值的次数
															
		}
		b[0] = map.lastKey(); // 先求出b[0]
		for (int i = 1; i < b.length; i++) {
			if (map.get(a[i - 1]) == 1) 
				map.remove(a[i - 1]); // 如果i的前一个数在map的出现次数为0, 则删掉
			else
				map.put(a[i - 1], map.get(a[i - 1]) - 1); // 次数减一
			map.put(a[i + win - 1], 1 + map.getOrDefault(a[i + win - 1], 0)); // 把刚接触到的数加入map
			b[i] = map.lastKey();
		}
		return b;
	}

	// 和max()的唯一区别在于TreeMap中记录的是某个数字最后一次出现的下标, 而不是出现次数
	public int[] max2(int[] a, int win) {
		int[] b = new int[a.length - win + 1];
		TreeMap<Integer, Integer> map = new TreeMap<>(); // 键为数字, 值为最后一次出现的下标
		for (int i = 0; i < win; i++) {
			map.put(a[i], i);
		}
		b[0] = map.lastKey();
		for (int i = 1; i < b.length; i++) {
			// 判断a[i-1]这个数最后出现的下标是否为i-1, 当i~i+win-1位置中也有数字等于a[i-1],
			// 此时a[i-1]最后出现的下标就不为i-1
			if (map.get(a[i - 1]) == i - 1) 
				// 如果是,说明a[i-1]在滑动窗口不存在了, 要删除掉
				map.remove(a[i - 1]);
			map.put(a[i + win - 1], i + win - 1); // 把刚接触到的数加入map
			b[i] = map.lastKey();
		}
		return b;
	}

	// 使用双端队列实现
	public int[] max3(int[] a, int win){
		int[] b =new int[a.length-win+1];
		LinkedList<Integer> deque = new LinkedList<>(); //存放的是数组下标
		// 先处理好第一个滑动窗口
		for(int i=0;i<win;i++){
			// 如果队列不为空并且队列的最后一个元素小于a[i]
			while(!deque.isEmpty()&&a[deque.peekLast()]<a[i]){
				// 则弹出队尾
				deque.pollLast();
			}
			//直到上面的while循环不满足, 把i下标加入队列.
			deque.offerLast(i);
		}
		// b[0]为队首元素
		b[0]=a[deque.peekFirst()];
		
		// 之后每移动一步, 都是一个新的滑动窗口, 为之后的每一个滑动窗口进行计算
		// i代表当前滑动窗口的最后一个元素
		// 注意: max()和max2()中, i代表当前滑动窗口的第一个元素
		for(int i=win;i<a.length;i++){
			// 如果队列不为空并且队列的最后一个元素小于a[i]
			while(!deque.isEmpty()&&a[deque.peekLast()]<a[i]){
				// 则弹出队尾
				deque.pollLast();
			}
			deque.offerLast(i);
			// 如果双端队列的队首是当前滑动窗口范围的前一个元素i-w, 就删除掉,因为已经过期了
			if(deque.peekFirst()==i-win){
				deque.pollFirst();
			}
			b[i-win+1]=a[deque.peekFirst()];
		}
		return b;
	}
	
	public static void main(String[] args) {
		int[] result = new Saq_5().max2(new int[] {1,3,4,4,4,4,2,2,2}, 3);
		System.out.println(Arrays.toString(result));
	}

}
