package dynamicProgramming;

public class DP_1 {

	/**
	 * 
	 * @param n
	 *            台阶数
	 * @return 有多少种跳法
	 */
	public static int jump(int n) {
		if (n <= 2)
			return n;
		int a = 1, b = 2, c = 0;
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(jump(9));
	}
}
