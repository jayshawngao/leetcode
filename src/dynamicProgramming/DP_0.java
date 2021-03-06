package dynamicProgramming;

public class DP_0 {

    // 暴力搜索方法
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    // 记忆搜索方法
    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length][aim + 1];
        return process2(arr, 0, aim, map);
    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                int mapValue = 0;

                if (index + 1 < arr.length) {
                    mapValue = map[index + 1][aim - arr[index] * i];
                }
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue; // 为-1时表示已经处理过, 但是结果为0
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }

            }
            map[index][aim] = res == 0 ? -1 : res;
        }
        return res;
    }

    // 动态搜索方法
    public static int coins3(int[] arr, int aim) {
        // 注意dp的大小
        // 为什么不是new int[arr.length+1][aim + 1]，因为不用任何面额纸币的方案，已经隐含在下面的行中，只要使用哪个行时，使用零张即可
        int[][] dp = new int[arr.length][aim + 1];
        // 初始化第一列
        for (int i = 0; i < arr.length; i++) {
            // 凑成0元，有1种方案
            dp[i][0] = 1;
        }
        // 初始化第一行
        for (int i = 0; i < aim + 1; i++) {
            if (i % arr[0] == 0) {
                // 如果可以整除，则有1种方案
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int temp = j - arr[i];
                if (temp >= 0)
                    dp[i][j] = dp[i][temp] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(coins1(new int[]{1, 2, 5}, 9));
    }
}
