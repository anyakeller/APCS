public class MonteHall{
    public static void run(double n){
	boolean  door1,door2,door3;
	double d;
	int win , loose;
	win = loose = 0;
	
	for (int i = 0; i < n; i ++){
	    door1 = door2 = door3 = false;
	    d = Math.random();
	    
	    if (d <= 1.0/3.0) door1 = true;
	    else if(d<= 2.0/3.0) door2 = true;
	    else door3 = true;

	    if (door1 == true) win++;
	    else loose++;
      
	}
	System.out.println("Keep door % sucess: " + ( win / n ) * 100);		       System.out.println("Change door % sucess: " + (loose / n)* 100);
    }

    public static void main(String[] args){
	int n;
	n = Integer.parseInt(args[0]);
	System.out.println("Monty Hall run " + n + " times");
	run(n);
    }
}