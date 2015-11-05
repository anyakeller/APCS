/******************************************************************************
 *  % more tiny.txt
 *  5 
 *  0 1 
 *  1 2  1 2 
 *  1 3  1 3  1 4 
 *  2 3 
 *  3 0 
 *  4 0  4 2 
 *
 *  % java Transition 90 < tiny.txt
 *  5 5
 *   0.02 0.92 0.02 0.02 0.02
 *   0.02 0.02 0.38 0.38 0.20
 *   0.02 0.02 0.02 0.92 0.02
 *   0.92 0.02 0.02 0.02 0.02
 *   0.47 0.02 0.47 0.02 0.02
 *
 problem 4: 
    fix your matix; this code is fine
 
 Problem 5:
    TurtleFumes:inOutUnit anyakeller$ java Transition 90 < tiny.txt | java RandomSurfer 10000
        0.27390 0.26390 0.14730 0.24400 0.07090
    TurtleFumes:inOutUnit anyakeller$ java Transition 90 < tiny.txt | java RandomSurfer 100000
        0.27249 0.26587 0.14661 0.24707 0.06796
        
Poblem 6:
    TurtleFumes:inOutUnit anyakeller$ java Transition 90 < tiny.txt | java Markov 2
        0.04700000000.03800000000.36020000000.36920000000.1856000000
    TurtleFumes:inOutUnit anyakeller$ java Transition 90 < tiny.txt | java Markov 2
        0.04700000000.03800000000.36020000000.36920000000.1856000000
    TurtleFumes:inOutUnit anyakeller$ java Transition 90 < tiny.txt | java Markov 8
        0.26534250080.31877233310.13363028220.21684285240.0654120315

Orig medium.txt:
    TurtleFumes:inOutUnit anyakeller$ java Transition 90 < medium.txt | java RandomSurfer 1000
    0.00400 0.02300 0.01200 0.00200 0.00600 0.01400 0.06800 0.01500 0.02000 0.04800 0.00300 0.02300 0.01000 0.04300 0.02100 0.01700 0.03200 0.00400 0.02200 0.02000 0.00300 0.03400 0.06900 0.04200 0.01000 0.00400 0.00400 0.00700 0.04200 0.00300 0.03400 0.02600 0.02500 0.01100 0.02100 0.02100 0.00200 0.02300 0.01200 0.02000 0.01400 0.01700 0.02000 0.01400 0.01400 0.01100 0.03100 0.02000 0.02100 0.01800
        
Problem 7:
    TurtleFumes:inOutUnit anyakeller$ java Transition 90 < medium.txt | java RandomSurfer 1000
 0.00400 0.00800 0.00900 0.00100 0.00500 0.02100 0.04800 0.03600 0.01100 0.05000 0.00100 0.02000 0.01300 0.03300 0.00900 0.02700 0.02500 0.00600 0.02000 0.02900 0.00300 0.01800 0.03900 0.03400 0.01800 0.00600 0.01900 0.01000 0.04500 0.00200 0.04200 0.01500 0.01800 0.01000 0.02700 0.02700 0.00100 0.04200 0.02000 0.02800 0.01300 0.03200 0.01600 0.02400 0.03000 0.00700 0.02600 0.02100 0.02000 0.01100
        
Problem 8:
    TurtleFumes:inOutUnit anyakeller$ java Transition 90 < medium.txt | java RandomSurfer 1000
    0.00400 0.02800 0.00800 0.00200 0.00500 0.00900 0.04500 0.01100 0.02400 0.01500 0.00500 0.07500 0.01100 0.02600 0.03900 0.01700 0.01000 0.00300 0.00600 0.02200 0.00400 0.08600 0.09300 0.18700 0.00400 0.00400 0.01100 0.00300 0.01100 0.00200 0.01600 0.01300 0.01100 0.01100 0.01700 0.01500 0.00300 0.01600 0.00800 0.00700 0.00900 0.00800 0.00800 0.00800 0.00600 0.01300 0.01300 0.01000 0.02300 0.01500
    
Problem 9:
    13 30 47
    
Problem 10:
    any link not 13, 30, or 47

Problem 11:
    

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
        StdOut.println("=============");
        //ignore(leapProb);
        StdOut.println("=============");
        //noOut(leapProb);
        
    } 
} 



