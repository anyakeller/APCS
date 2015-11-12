/******************************************************************************
 *  MODIFIED VERSION OF RandomSurfer.java FOR  CREATIVE EXCERCISE 17
 *  % java Transition 90 < tiny.txt | java HittingTime 1000000
 *
 ******************************************************************************/

public class HittingTime {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);    // number of moves
        int M = StdIn.readInt();              // number of pages  - ignore since M = N
        int N = StdIn.readInt();              // number of pages
        if (M != N) throw new RuntimeException("M does not equal N");

        // Read transition matrix.
        double[][] p = new double[N][N];     // p[i][j] = prob. that surfer moves from page i to page j
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) 
                p[i][j] = StdIn.readDouble(); 


        int[] freq = new int[N];            // freq[i] = # times surfer hits page i
 
        // Start at page 0. 
        int page = 0;
        
        /*
         * 
         *           not | sum | count
         *         -------------------
         *  page 1 |     |     |      |
         *         -------------------
         *  page 2 |     |     |      |
         * 
         * 
         * */
        
        int [][] count = new int[N][3];
        
        for (int t = 0; t < T; t++) {

            // Make one random move. 
            double r = Math.random(); 
            double sum = 0.0; 
            for (int j = 0; j < N; j++) {
                // Find interval containing r. 
                sum += p[page][j]; 
                if (r < sum) {
                    page = j;
                    
                    
                    //code to calculate hitting times
                    for (int i = 0; i < N; i++){
                      if (i != page){                    //every move that does not land on page i adds to its count
                       count[i][0]++;                    //
                      }
                      
                      else{                              //if the surfer moved to page i
                        count[i][2] += count[i][0];      //add the number of moves in between this jump and last jump
                        count[i][0] = 0;                 //set the number of jumps between last and next to 0 (reset counter)
                        count[i][1]++;                   //add 1 to number of times page i has been visited
                      }
                      
                    }
                    
                    
                    //end
                    
                    break;
                } 
            } 
            freq[page]++; 
        } 


        // Print page ranks. 
        for (int i = 0; i < N; i++) {
            StdOut.printf("Page Rank: %8.5f \n", (double) freq[i] / T);
            StdOut.printf("Hitting Time: %8.5f \n",((double) count[i][2] / count[i][1]) + 1);
            StdOut.printf("1 / Page: %8.5f \n", 1.0 / ((double)freq[i] / T));
            System.out.println();
        }
        StdOut.println(); 
    }  
} 
