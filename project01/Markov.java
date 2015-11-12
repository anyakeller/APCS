/******************************************************************************
 BASELINE CODE TAKEN FROM http://introcs.cs.princeton.edu/java/16pagerank/
 
 *  % java Transition 90 < tiny.txt | java Markov 40
 *   0.27303 0.26573 0.14618 0.24723 0.06783
 *
 ******************************************************************************/

public class Markov {

    public static void main(String[] args) { 
        int T = Integer.parseInt(args[0]);    // number of iterations
        int N = StdIn.readInt();              // number of pages
        StdIn.readInt();                      // ignore integer required by input format


        // Read p[][] from StdIn. 
        double[][] p = new double[N][N];     // p[i][j] = prob. surfer moves from page i to page j
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) 
                p[i][j] = StdIn.readDouble(); 

        // Use the power method to compute page ranks. 
        double[] rank = new double[N]; 
        rank[0] = 1.0; 
        for (int t = 0; t < T; t++) {

            // Compute effect of next move on page ranks. 
            double[] newRank = new double[N]; 
            for (int j = 0; j < N; j++) {
                //  New rank of page j is dot product of old ranks and column j of p[][]. 
                for (int k = 0; k < N; k++) 
                   newRank[j] += rank[k]*p[k][j]; 
            } 

            // Update page ranks.
            rank = newRank;
        } 


        // print page ranks
        for (int i = 0; i < N; i++) {
            StdOut.printf("%8.10f ", rank[i]);  
        }
        StdOut.println(); 
    } 
} 
