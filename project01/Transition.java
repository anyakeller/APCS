/******************************************************************************
BASELINE CODE TAKEN FROM http://introcs.cs.princeton.edu/java/16pagerank/

 *  $ more tiny.txt
 *  5 
 *  0 1 
 *  1 2  1 2 
 *  1 3  1 3  1 4 
 *  2 3 
 *  3 0 
 *  4 0  4 2 
 *
 *  $ java Transition 90 < tiny.txt
 *  5 5
 *   0.02 0.92 0.02 0.02 0.02
 *   0.02 0.02 0.38 0.38 0.20
 *   0.02 0.02 0.02 0.92 0.02
 *   0.92 0.02 0.02 0.02 0.02
 *   0.47 0.02 0.47 0.02 0.02
 *
 
 RUNNING CODE
 
 There are three methods: normal, ignore, noOut.
 They are called at the end of the file
 normal - the original code with edits for leapProb input
 ignore - edited to ignore multiple links
 noOut - edited to handle pages with no links
 
 To run this code:
 $java Transition [leap probability 0 to 100] < [filename].txt
 ex:
 $java Transition 90 < tiny.txt

 ******************************************************************************/

public class Transition {

    public static void normal(int leapProb){
        int N = StdIn.readInt();           // number of pages
        int[][] counts = new int[N][N];    // counts[i][j] = # links from page i to page j
        int[] outDegree = new int[N];      // outDegree[i] = # links from page i to anywhere

        // Accumulate link counts.  
        while (!StdIn.isEmpty())  {
            int i = StdIn.readInt(); 
            int j = StdIn.readInt(); 
            outDegree[i]++; 
            counts[i][j]++; 
        } 
        StdOut.println(N + " " + N); 


        // Print probability distribution for row i. 
        for (int i = 0; i < N; i++)  {

            // Print probability for column j. 
            for (int j = 0; j < N; j++) {
                double p = 0.01 * leapProb * counts[i][j]/outDegree[i] + ((.01 * (100-leapProb))/N); 
                StdOut.printf("%7.5f ", p); 
            } 
            StdOut.println(); 
        } 
    }
    
    
    //Exercise 2: Ignore multiple links
    public static void ignore(int leapProb){  
        int N = StdIn.readInt();           // number of pages
        int[][] counts = new int[N][N];    // counts[i][j] = # links from page i to page j
        int[] outDegree = new int[N];      // outDegree[i] = # links from page i to anywhere

        // Accumulate link counts.  
        while (!StdIn.isEmpty())  {
            int i = StdIn.readInt(); 
            int j = StdIn.readInt(); 
            if (counts[i][j] == 0){
                outDegree[i]++; 
                counts[i][j]++;
            }
        } 
        StdOut.println(N + " " + N); 


        // Print probability distribution for row i. 
        for (int i = 0; i < N; i++)  {

            // Print probability for column j. 
            for (int j = 0; j < N; j++) {
                double p = 0.01 * leapProb * counts[i][j]/outDegree[i] + ((.01 * (100-leapProb))/N); 
                StdOut.printf("%7.5f ", p); 
            } 
            StdOut.println(); 
        } 
    }
        
    //Exercise 3: Case of no outgoing links
    public static void noOut(int leapProb){
        int N = StdIn.readInt();           // number of pages
        int[][] counts = new int[N][N];    // counts[i][j] = # links from page i to page j
        int[] outDegree = new int[N];      // outDegree[i] = # links from page i to anywhere

        // Accumulate link counts.  
        while (!StdIn.isEmpty())  {
            int i = StdIn.readInt(); 
            int j = StdIn.readInt(); 
            outDegree[i]++; 
            counts[i][j]++;
        } 
        StdOut.println(N + " " + N); 

        // Print probability distribution for row i. 
        for (int i = 0; i < N; i++)  {
            boolean isEmpty = true;
            
            for (int j = 0; j < N; j++) {
                if (counts[i][j] != 0) isEmpty = false;
            }
            if (isEmpty){
                double p = 1.0/N;
                for (int j = 0; j <  N; j ++) StdOut.printf("%7.5f ", p); 
            }
            else{
            // Print probability for column j. 
                for (int j = 0; j < N; j++) {
                    double p = 0.01 * leapProb * counts[i][j]/outDegree[i] + ((.01 * (100-leapProb))/N); 
                    StdOut.printf("%7.5f ", p); 
                } 
            }
            StdOut.println(); 
        } 
    }
        
    public static void main(String[] args) {

        int leapProb = Integer.parseInt(args[0]);
        normal(leapProb);
        //StdOut.println("=============");
        //ignore(leapProb);
        //StdOut.println("=============");
        //noOut(leapProb);
        
    } 
} 



