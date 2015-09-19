public class QuadSolver{
    public static void main(String[] args){
	double a , b, c,des,r1,r2;
	a = args[0];
	b = args[1];
	c = args[2];
	
	des = (b * b -(4*a*c));
	if (des < 0){
	    System.out.println("invalid");
	}
	else{
	    r1 = -1 *b + des
	}
	

	System.out.println();

    }
}
