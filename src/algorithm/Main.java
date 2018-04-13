package algorithm;

public class Main {

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 129;
		Integer f = 129;
		Integer h = 258;
		Long g = 3L;
		System.out.println(c==d);
		System.out.println(e==f);
		System.out.println(c==(a+b));
		System.out.println(c.equals(a+b));
		System.out.println(g==(a+b));
		System.out.println(g.equals(a+b));
		System.out.println(h==(e+f));
		System.out.println(h.equals(e+f));
	}
}
