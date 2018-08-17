package dynamicProgramming;


public class DP_2 {

    /**
     * @param a 数字矩阵
     * @return 从左上角到右下角所经历的数字和的最小值
     */
    public static int min(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        dp[0][0] = a[0][0];
        // 初始化第一列
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
        }
        // 初始化第一行
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + a[0][j];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    // 和min的区别在于dp+1, 为了测试dp+1是否能简化编码，结果是反而复杂了
    public static int min2(int[][] a) {
        // 注意dp的大小
        int[][] dp = new int[a.length + 1][a[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    // 这里的两个else if不加就会错,为什么?
                    // 因为当i=1时,对应着原数组的第一行, 此时只能从左边过来而不能从上面过来, j==1同理
                } else if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + a[i - 1][j - 1];
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + a[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i - 1][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(min(a));
        System.out.println(min2(a));
    }
}
