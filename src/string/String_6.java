package string;

import java.util.Arrays;
import java.util.Comparator;

// 最小字典序拼接字符串数组
// 其实质是排序的实现
// 但注意避免一种错误的排序实现方法, 见笔记
public class String_6 {

	public String concat(String[] strs){
		Arrays.sort(strs, new StringComparator());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<strs.length;i++){
			sb.append(strs[i]);
		}
		return sb.toString();
	}
	
	class StringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return (o1+o2).compareTo(o2+o1);
		}
		
	}
	
	public static void main(String[] args) {
		String[] strs = new String[]{"b","ba","abc","de"};
		System.out.println(new String_6().concat(strs));
	}
}
