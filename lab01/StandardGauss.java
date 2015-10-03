public class StandardGauss{
    public static void main (String[] args){
	double u,v,w;
	u = Math.random();
	v = Math.random();
	w = Math.sin(2 * Math.PI * v)*Math.pow((-2 * Math.log(u)),0.5);
	System.out.println(w);
    }
}
