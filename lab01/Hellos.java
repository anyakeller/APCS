public class Hellos{
    public static void main (String [] args){
       	int N,i,d;
	N = Integer.parseInt(args[0]);
	d = 0;
	i = 1;
	String suffix;

	while ((d*10 + i) <= N){
	    
	    if (d == 1) suffix = "th";
	    else {
		if (i == 1) suffix = "st";		
		else if (i == 2) suffix = "nd";
		else if (i == 3) suffix = "rd";
		else suffix = "th";
	    }
	    

	    if (d == 0) System.out.println(i + suffix + " Hello");
	    else System.out.println((d * 10) + i + suffix + " Hello");

	    if (i == 9) {
		d+=1; 
		i = 0;
	    }
	    else i += 1;
	    
	}
    }
}
