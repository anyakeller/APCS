public class PageGen{
    
    public static boolean contains(int[] l, int x){
        boolean has = false;
        for (int i = 0; i < l.length; i++){
            if (l[i] == x){
                has = true;
                break;
            }
        }
        return has;
    }
    
    public static int[] randomPgList(int pages, int x){ // x = pages to find
        int[] ten = new int[x]; 
        for (int i = 0; i < ten.length; i++){
            int temp = (int)(Math.random() * pages); 
            while (contains(ten,temp)) temp = (int)(Math.random() * pages); 
            ten[i] = temp;
        }
        return ten;
    }
    
    public static void main(String[] args){
        
        int pages = Integer.parseInt(args[0]);
        int links = Integer.parseInt(args[1]);
        int hubs = Integer.parseInt(args[2]); //10% point to 
        int[] hublist = new int[hubs];
        for (int i = 0; i < hubs; i++) hublist[i] = pages;
        int auth = Integer.parseInt(args[3]); //points to 10%
        int[] authlist = new int[auth];
        for (int i = 0; i < auth; i++) authlist[i] = pages;
        
        
        for (int i = 0; i < hubs;i++){
            int currHub = (int)(Math.random() * pages);
            while (contains(hublist, currHub)) currHub = (int)(Math.random() * pages);
            int[] hubsource = randomPgList(pages, (int)(pages * 0.1));
            for (int source:hubsource) StdOut.print(source + " " + currHub + " ");
            StdOut.println();
            links--;
        }
                
        for (int i = 0; i < auth;i++){
            int currAuth = (int)(Math.random() * pages);
            while (contains(authlist, currAuth)) currAuth = (int)(Math.random() * pages);
            int[] authsource = randomPgList(pages, (int)(pages * 0.1));
            for (int source:authsource) StdOut.print(currAuth + " " + source + " ");
            StdOut.println();
            links--;
        }
        
        while (links > 0){
            
            int loc = (int)(Math.random() * pages); // location
            int dest = (int)(Math.random() * pages); // destination
            
            StdOut.println(loc + " " + dest);
            links--;
        }
        
    }    
}