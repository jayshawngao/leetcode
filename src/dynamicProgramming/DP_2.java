package dynamicProgramming;

import java.util.Arrays;

public class DP_2 {

	/**
	 * 
	 * @param a
	 *            ���־���
	 * @return �����Ͻǵ����½������������ֺ͵���Сֵ
	 */
	public static int min(int[][] a) {
		int[][] dp = new int[a.length][a[0].length];
		dp[0][0]=a[0][0];
		for(int i=1;i<dp.length;i++){
			dp[i][0] = dp[i-1][0]+a[i][0];
		}
		for(int j=1;j<dp[0].length;j++){
			dp[0][j] = dp[0][j-1]+a[0][j];
		}
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+a[i][j];
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	
	// ��min����������dp+1, Ϊ�˲���dp+1�Ƿ��ܼ򻯱���
	public static int min2(int[][] a) {
		// ע��dp�Ĵ�С
		int[][] dp = new int[a.length+1][a[0].length+1];
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				if(i==0||j==0){
					dp[i][j]=0;
				// ���������else if���Ӿͻ��,Ϊʲô?
				// ��Ϊ��i=1ʱ,��Ӧ��ԭ����ĵ�һ��, ��ʱֻ�ܴ���߹��������ܴ��������, j==1ͬ��
				}else if(i==1){
					dp[i][j] =dp[i][j-1]+a[i-1][j-1];
				}else if(j==1){
					dp[i][j]=dp[i-1][j]+a[i-1][j-1];
				}else{
					dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+a[i-1][j-1];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	
	public static void main(String[] args) {
		int[][]a = new int[][]{{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
		System.out.println(min(a));
		System.out.println(min2(a));
	}
}
