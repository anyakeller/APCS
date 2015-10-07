public class PrimeFactors{
    public static void primeFactors(int n){
	int count = 2;
	System.out.print("Prime factors of "+ n + ": ");
	for (;count <= n;count++){
	    if (n % count == 0){
		System.out.print(count + " ");
		n = n / count;
		count = 1;
	    }
	}
	System.out.print("\n");
    }
    
    public static void morePrimeFactors(int n, int t){
	for (; n < t; n++){
	    primeFactors(n);
	}
    }

    public static void main (String [] args){
	morePrimeFactors(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }
}