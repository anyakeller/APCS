//$java GraphicSim < medRank.txt 

public class GraphicSim{
    
    public static void main(String[] args) {
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(StdDraw.RED);
        int N = StdIn.readInt();
        double d = StdIn.readDouble();
        
        for (int i = 0; i < N; i++){
            for (int k = 0; k < N; k++){
                double r = (1/d) * Math.sqrt((StdIn.readDouble()) / (Math.PI));
                double x =  0.5 * (1.0/d) + (1/d) * k;
                double y =  0.5 * (1.0/d) + (1/d) * i;
                StdDraw.filledCircle(x, y, r);
            }
        }
    }
}