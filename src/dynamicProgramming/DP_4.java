package dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DP_4 {

    private char[] a;
    private char[] b;
    private int[][] dp;
    private Set<String> res;

    public DP_4(String s1, String s2) {
        a = s1.toCharArray();
        b = s2.toCharArray();

        dp = new int[a.length + 1][b.length + 1];
        res = new HashSet<>();
        cacDP();
        cacSet(dp.length - 1, dp[0].length - 1, "");

    }

    // 用于求出dp[][]
    private void cacDP() {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1] + (a[i - 1] == b[j - 1] ? 1 : 0));
                }

            }
        }

    }

    // 用于计算Set
    private void cacSet(int i, int j, String s) {
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                s = a[i - 1] + s;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                j--;
            } else {
                cacSet(i - 1, j, s);
                cacSet(i, j - 1, s);
                // 这里必须加return, 如果不加, cacSet返回之后,
                // 又进入了while循环,break也不行, 因为不可以再执行下面的代码
                return;
            }

        }

        res.add(s);
    }

    public Set<String> getRes() {
        return res;
    }

    public int getLength() {
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        DP_4 dp_4 = new DP_4(s1, s2);
        System.out.println(dp_4.getLength());
        System.out.println(dp_4.getRes());
    }
}
