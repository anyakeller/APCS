public class MinChange{
    public static void main(String[] args){
        System.out.println("Here is your change ");
        int coins = Integer.parseInt(args[0]);
        int q = 0;
        int d = 0;
        int n = 0;
        int p = 0;
        int change;
    //asdfas    
        
        q = coins / 25;
        coins = coins % 25;
        d = coins / 10;
        coins = coins % 10;
        n = coins / 5;
        coins = coins % 5;
        p = coins;

        System.out.println("quarters: " +q);
        System.out.println("dimes: " +d);
        System.out.println("nickels: " +n);
        System.out.println("pennies: " +p);
    }
}
