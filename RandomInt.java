public class RandomInt{
	public static void main(String[] args){
	double r = Double.parseDouble(args[0]);
	System.out.println(((int)(Math.random() * r + 1))-1);
	}
}
