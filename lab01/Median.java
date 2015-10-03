public class Median{
    public static void main (String[] args) {
      	int a,b,c,d,e,g,s,median;
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        c = Integer.parseInt(args[2]);
        d = Integer.parseInt(args[3]);
        e = Integer.parseInt(args[4]);
        g = Math.max(a,Math.max(b,Math.max(c,Math.max(d,e))));
        s = Math.min(a,Math.min(b,Math.min(c,Math.min(d,e)))); 
	
	if (g == a) a = s;
	else if (g == b) b = s;
	else if (g == c) c = s;
	else if (g == d) d = s;
	else e = s;

	g = Math.max(a,Math.max(b,Math.max(c,Math.max(d,e))));
        s = Math.min(a,Math.min(b,Math.min(c,Math.min(d,e))));

	if (g == a) a = s;
	else if(g == b) b = s;
	else if(g == c) c = s;
	else if(g == d) d = s;
	else e = s;
	
	median  = Math.max(a,Math.max(b,Math.max(c,Math.max(d,e))));
	System.out.println(median);
    }
}
