package bit;

import java.util.Arrays;

public class Bit_5 {

    // 返回数组中唯二出现奇数次的元素
    public int[] findOdd(int[] a) {
        int eo = 0;
        for (int i = 0; i < a.length; i++) {
            eo ^= a[i];
        }
        String bitStr = Integer.toBinaryString(eo);
        int eo2 = 0;
        for (int i = 0; i < a.length; i++) {
            String temp = Integer.toBinaryString(a[i]);
            if (temp.charAt(temp.length() - bitStr.length()) == '1') {
                eo2 ^= a[i];
            }
        }
        return new int[]{eo2, eo ^ eo2};
    }

    public static void main(String[] args) {
        int[] res = new Bit_5().findOdd(new int[]{4, 2, 1, 3, 5, 1, 4, 5});
        System.out.println(Arrays.toString(res));
    }
}
