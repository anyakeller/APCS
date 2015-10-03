public class VerifyStdGauss{
    public static void main (String[] args){
	int N, r1,r2,r3,r4,r5,r6,r7; // r is range
	double u,v,w;
	r1 = r2 = r3 = r4 = r5 = r6 = r7 = 0;
	N = Integer.parseInt(args[0]);

	while (N > 0){
	    u = Math.random();
	    v = Math.random();
	    w = Math.sin(2 * Math.PI * v)*Math.pow((-2 * Math.log(u)),0.5);
	    if (w < -2.5) r1++; // 0.6%
	    else if (w <= -1.5) r2++; // 6.1%
	    else if (w <= -0.5) r3++; // 24.2%
	    else if (w <= 0.5) r4++; // 38.2%
	    else if (w <= 1.5) r5++; // 24.2%
	    else if (w <= 2.5) r6++; // 6.1%
	    else r7++; // 0.6%
	    N--;
	}	

	System.out.println("(-Inf, -2.5]: " + r1);
	System.out.println("(-2.5, -1.5]: " + r2);
	System.out.println("(-1.5, -0.5]: " + r3);
	System.out.println("(-0.5,0.5]: " + r4);
	System.out.println("(0.5, 1.5]: " + r5);
	System.out.println("(1.5, 2.5]: " + r6);
	System.out.println("(2.5, +Inf): " + r7);
    }
}
	    
	    
