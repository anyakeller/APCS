public class QuadSolver{
    public static void main(String[] args){
        double a , b, c,dis,r1,r2;
        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);
        
        dis = (b * b -(4*a*c));  //dis is the discriminant
	
        if (dis < 0){
		System.out.println("There are no roots.");
        }
        else{
		r1 = ((-1 * b) + Math.sqrt(dis)) / (2.0 * a);
		r2 = ((-1 * b) -  Math.sqrt(dis)) / (2.0 * a);
		System.out.println("roots: " + r1 + ", " + r2);
        } 
    }
}
