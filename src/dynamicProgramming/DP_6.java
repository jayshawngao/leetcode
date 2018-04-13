package dynamicProgramming;

public class DP_6 {

	private static final int rc = 1; //替换代价
	private static final int dc = 1; //删除代价
	private static final int ic = 1; //插入代价
	
	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return 将s1编辑成s2的最小代价
	 */
	public static int cost(String s1, String s2){
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		dp[0][0]=0;
		for(int i=1;i<dp.length;i++){
			dp[i][0]=dc*i;
		}
		for(int j=1;j<dp[0].length;j++){
			dp[0][j]=ic*j;
		}
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				int a = dc+dp[i-1][j];
				int b = dp[i][j-1]+ic;
				int c=0;
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					c=dp[i-1][j-1];
				}else{
					c=dp[i-1][j-1]+rc;
				}
				dp[i][j]=Math.min(Math.min(a, b),c);
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	public static void main(String[] args) {
		System.out.println(cost("aa", "aac"));
	}
}
