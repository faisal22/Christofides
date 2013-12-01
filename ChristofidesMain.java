import java.util.Arrays;
import java.io.IOException;

class ChristofidesMain{

        public static void main(String [] args){
                try{
                        Christofides ch = new Christofides(true);
                        int [] shortestPath = ch.solve(ChristofidesManager.getManager().readDistanceMatrix("./Datasets/input5.txt"));
                        System.out.println(Arrays.toString(shortestPath));
                }
                catch(IOException e){
                        e.printStackTrace();
                }
        }


}