package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序的基本思想是：把数组 arr 划分为n个大小相同子区间（桶），每个子区间各自排序，最后合并。
 * 计数排序是桶排序的一种特殊情况，可以把计数排序当成每个桶里只有一个元素的情况。
 * 
 * 1.找出待排序数组中的最大值max、最小值min 2.我们使用 动态数组ArrayList 作为桶，桶里放的元素也用 ArrayList
 * 存储。桶的数量为(max-min)/arr.length+1 3.遍历数组 arr，计算每个元素 arr[i] 放的桶 4.每个桶各自排序
 * 5.遍历桶数组，把排序好的元素放进输出数组
 * 
 * @ClassName: BucketSort
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Jayshawn
 * @date 2018年1月7日 下午2:48:07
 *
 */
public class BucketSort {

	public void bucketSort(int[] a) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
			if (min > a[i])
				min = a[i];
		}
		int bucketNum = (max-min)/a.length+1; // 为什么要加1 ,因为max会放在(max-min)/a.length号桶, 而会放在0号桶
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<bucketNum;i++){
			list.add(new ArrayList<Integer>());
		}
		for(int i=9;i<a.length;i++){
			int index = (a[i]-min)/a.length;
			list.get(index).add(a[i]);
		}
		for(int i=0;i<bucketNum;i++){
			Collections.sort(list.get(i));
		}
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{43,54,5452,5,4,54,24,24,542,4,53,756,978,567,345,24,25,6,7,58,474,456,2,56};
		new BucketSort().bucketSort(a);
	}
}
