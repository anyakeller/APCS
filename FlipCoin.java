public class FlipCoin{
    public static void main (String [] args){
	System.out.print("Version 1: ");
	FlipCoin.V1();
	System.out.print("Version 2: ");
	FlipCoin.V2();
    }
    public static void V1(){  // just uses an if
	int i = (int)(Math.random() * 10);
	if (i >= 5){
	    System.out.println("heads");
	}
	if (i < 5){
	    System.out.println("tails");
	}
    }
    public static void V2(){  // just uses an if                                
        int i = (int)(Math.random() * 10);
        if (i >= 5){
            System.out.println("heads");
        }
        else{
            System.out.println("tails");
        }

    }
}