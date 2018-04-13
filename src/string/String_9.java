package string;

import java.util.HashMap;
import java.util.Map;

// 最长无重复子串长度
public class String_9 {

	public int longestSubString(String s) {
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<>(); // 记录每个c上次出现的位置
		int pre = 0; //记录上一个位置的最长长度
		for (int i = 0; i < s.length(); i++) {
			int last = map.get(s.charAt(i)) == null ? -1 : map.get(s.charAt(i)); // 获得当前c上次出现的位置,如果没有出现过则为-1
			last++; // 指向当前c上次出现的位置的下一个位置
			int temp = Math.max(pre, last); // 取最大值, 表示当前c能够向左的最远的位置
			result = Math.max(result, i - temp + 1); // 更新result
			map.put(s.charAt(i), i); // 更新map
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new String_9().longestSubString("abcb"));
	}
}
