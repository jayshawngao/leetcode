package dynamicProgramming;

public class DP_5 {

	/**
	 * 
	 * @param W 背包承重
	 * @param N 物品总数
	 * @param v 物品价值数组
	 * @param w 物品重量数组
	 * @return 背包所能装下的最大价值
	 */
	public static int maxValue(int W, int N,  int[] v, int[] w){
		// dp[i][j]表示前i件物品, 不超过重量j时的最大价值
		int[][] dp = new int[N+1][W+1];
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				if(i==0||j==0){
					dp[i][j]=0;
				}else{
					if(j-w[i-1]>=0){
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1]);
					}else{
						dp[i][j]=dp[i-1][j];
					}
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
		
	}
	
	public static void main(String[] args) {
		System.out.println(maxValue(100,5,new int[]{92,22,87,46,90},new int[]{77,22,29,50,99}));
	}
}
