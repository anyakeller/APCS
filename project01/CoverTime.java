//$java CoverTime < TransitionTiny.txt

public class CoverTime{
  
  public static boolean allT(boolean [] a){
    int N = a.length;
    for (int i = 0; i < N; i++){
      if (a[i] == false) return false; 
    }
    return true;
  }
  
  public static void main(String [] args){
    int N = StdIn.readInt(); //how many pages
    int N2 = StdIn.readInt();
    double data [][] = new double[N][N2];
    
    while (!StdIn.isEmpty()){
      for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
          data[i][j] = StdIn.readDouble();
        }
      }
    }
    
    boolean hit [] = new boolean[N];
    int times = 1; //random page at first
    int a = (int)(Math.random() * N);
    hit[a] = true;
        
    for (; allT(hit)==false; times++){
        double b = Math.random();
        for (int j = 0; j < N; j++){
          if (b < data[a][j]){
            hit[j] = true;
            a = j;
	    break;
          }
          else b -= data[a][j];
        }
    }
    
  System.out.println(times);  
    
  }
}
