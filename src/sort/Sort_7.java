package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 最大差值
public class Sort_7 {

	public int find(int[] a){
		int bucketNum = a.length+1;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++){
			if(max<a[i]) max=a[i];
			if(min>a[i]) min = a[i];
		}
		ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
		for(int i=0;i<bucketNum;i++){
			bucket.add(new ArrayList<Integer>());
		}
		for(int i=0;i<a.length;i++){
			int index = (a[i]-min)*(bucketNum-1)/(max-min);
			bucket.get(index).add(a[i]);
		}
		for(int i=0;i<bucketNum;i++){
			Collections.sort(bucket.get(i));
		}
		int i = 0, j=1, res= 0;
		while(j<bucketNum){
			if(bucket.get(j).size()==0) j++; // 如果桶为空, 跳过
			else{
				res = Math.max(res, bucket.get(j).get(0)-bucket.get(i).get(bucket.get(i).size()-1));
				i=j++;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{7,9,3,4,2,1,8};
		System.out.println(new Sort_7().find(a));
	}
}
