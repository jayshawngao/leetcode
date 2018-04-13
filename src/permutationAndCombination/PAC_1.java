package permutationAndCombination;

public class PAC_1 {

	public static int steps(int a, int b){
		int res = 1;
		int c = a+b-2;
		int d = a-1;
		for(int i=0;i<d;i++){
			res *= (c-i);
		}
		for(int i=0;i<d;i++){
			res /= (d-i);
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		System.out.println(steps(6, 9));
	}
}
