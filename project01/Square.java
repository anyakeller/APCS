// $java Transition 90 < tiny.txt | java Square 10
public class Square{
    
    public static double[][] squareProduct(double[][] x, double[][] y){
        int N =  x.length;
        double[][] z = new double[N][N];
        for (int i = 0; i < N; i++){
            for (int k = 0; k< N; k++){
                double hold = 0;
                for (int j = 0; j < N; j++){
                    hold += x[i][j] * y[k][j];
                }
                z[i][k] = hold;
            }
        }
        return z;
    }
    
    public static void main(String[] args){
        
        int runs = Integer.parseInt(args[0]) - 1;
        
        int N = StdIn.readInt();
        N = StdIn.readInt();
        double[][] x = new double[N][N];
        for (int i = 0; i < N; i++){
            for (int k = 0; k < N; k++){
                x[i][k] = Math.sqrt(StdIn.readDouble());
            }
        }
        
        double[][] z = squareProduct(x,x);
        
        while (runs > 0){
            z = squareProduct(x,z);
            runs --;
        }
        
        for (double[] i:z){
            for(double j:i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        
    }    
}