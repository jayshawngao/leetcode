package sort;

// 已排序二维数组中找数
public class Sort_5 {

	public boolean find(int[][] a, int target){
		int row = a.length-1;
		int col = a[0].length-1;
		int i = 0, j=col;
		while(i<=row&&j>=0){
			if(a[i][j]==target) return true;
			else if(a[i][j]>target) j--;
			else i++;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		int[][]a = new int[][]{{0,1,2,5},
								{2,3,4,7},
								{4,4,4,8},
								{5,7,7,9}};
		System.out.println(new Sort_5().find(a, 6));
		
		
	}
}
