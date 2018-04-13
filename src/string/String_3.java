package string;

// 判断两个字符串是否互为旋转词
public class String_3 {

	public boolean judge(String s1, String s2) {
		s1 = s1 + s1;
		return kmp(s1, s2);

	}

	public int[] getNext(String s) {
		int[] next = new int[s.length()];
		next[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			int k = next[i - 1];
			while (k > 0 && s.charAt(k) != s.charAt(i)) {
				k = next[k - 1];
			}
			if (s.charAt(i) == s.charAt(k)) {
				k++;
			}
			next[i] = k;
		}
		return next;
	}

	public boolean kmp(String s1, String s2) {
		int[] next = getNext(s2);
		int pos = 0;// 指向s2
		for (int i = 0; i < s1.length(); i++) {
			while (pos > 0 && s1.charAt(i) != s2.charAt(pos)) {
				pos = next[pos - 1];
			}
			if (s1.charAt(i) == s2.charAt(pos))
				pos++;
			if (pos == s2.length())
				return true;

		}
		return false;
	}

	public static void main(String[] args) {
		String s1 = "1234";
		String s2 ="3412";
		System.out.println(new String_3().judge(s1, s2));
	}
}
