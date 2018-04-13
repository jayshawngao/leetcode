package sort;

public class Sort_6 {

	public int needSort(int[] a){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int right = 0;
		int left = a.length-1;
		for(int i=0; i<a.length;i++){
			if(max<=a[i]) max=a[i];
			else right=i;
		}
		for(int i=a.length-1;i>=0;i--){
			if(min>=a[i]) min=a[i];
			else left=i;
		}
		return right-left+1;
	}
	public static void main(String[] args) {
		int[] a = new int[]{1,5,4,3,2,6,7};
		System.out.println(new Sort_6().needSort(a));
	}
}
