package dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class DP_3 {

    /**
     * @param a 数组
     * @return 数组的最长递增子序列
     */
    public static int max(int[] a) {
        if (a == null || a.length == 0) return 0;
        int[] dp = new int[a.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }


    // 和max的区别在于dp+1, 为了测试dp+1是否能简化编码，结果是并不能
    public static int max2(int[] a) {
        if (a == null || a.length == 0) return 0;
        int[] dp = new int[a.length + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else {
                int max = 0;
                // 这个for循环考验对dp数组的理解
                // 注意dp[i]对应着a[i-1]处的最长递增子序列
                for (int j = 0; j < i - 1; j++) {
                    if (a[j] < a[i - 1]) {
                        max = Math.max(max, dp[j + 1]);
                    }
                }
                dp[i] = max + 1;
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7}));
        System.out.println(max2(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7}));
    }
}
