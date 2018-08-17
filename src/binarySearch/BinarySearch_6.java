package binarySearch;

public class BinarySearch_6 {

    public int pow(int a, int b) {
        int base = a, res = 1;
        while (b != 0) {
            int c = b & 1;
            if (c == 1) {
                res *= base;
            }
            base *= base;
            b >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new BinarySearch_6().pow(2, 10));
    }
}
