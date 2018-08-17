package string;

import java.util.Arrays;

public class KMP {

	// 计算next表，next表的元素表示以当前位置结尾，最大的前缀后缀相同长度，这样比较失败时，可以直接跳到前缀处
	public int[] next(String s) {
		int[] next = new int[s.length()];
		next[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			// 上一个数的最大相同前后缀的长度
			int k = next[i - 1];
			// k>0, 且当前位置i和  i-1的最大相同前缀位置的后一个位置k 不相等, 就是说不能连贯下来时
			while (k > 0 && s.charAt(i) != s.charAt(k)) {
				// next[k-1]表示k-1位置的数的最大相同前后缀的长度,
				// 实际上 s.charAt(k-1)==s.charAt(next[k-1]-1), 就是说找一个子串,
				// 也是以s.charAt(k-1)为结尾,
				// 然后再比较下一个数和s.charAt(i)是否相等, 如果相等,则相当于连贯下来了
				k = next[k - 1];
			}
			if (s.charAt(i) == s.charAt(k))
				k++;
			next[i] = k;
		}
		return next;
	}

	// 返回-1表示没有子串
	public int kmp(String A, String a) {
		int[] next = next(a);
		int pos = 0; // 指向a的当前比较下标
		for (int i = 0; i < A.length(); i++) {
			// 如果当前匹配值不同, 且pos指向的不是a的头
			while (pos > 0 && A.charAt(i) != a.charAt(pos)) {
				// 则将pos移到pos-1的next的下一位置, 继续和当前的A.charAt(i)比较
				pos = next[pos - 1];
			}
			if (A.charAt(i) == a.charAt(pos))
				pos++;
			if (pos == a.length()) //由于pos指向的是下轮比较的下标, 所以不需要减1
				return i - a.length() + 1;
		}
		return -1;

	}

	public static void main(String[] args) {
		String A = "BBC ABCDAB ABCDABCDABDE";
		String a = "ABCDABD";
		System.out.println(new KMP().kmp(A, a));
	}
}
