import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChristofidesManager {
        
        public static ChristofidesManager instance = new ChristofidesManager();
        // public static final String INPUT_FILE = "input1.txt";
        // public int[][] matrix;
        
        // public static void main(String[] args) {
        //         GeneticManager gm = new GeneticManager();
        //         try {
        //                 gm.readDistanceMatrix();
        //         } catch (IOException e) {
        //                 System.err.println(e);
        //         }
        //         gm.printMatrix();
        // }
                
        private ChristofidesManager() {       
        }

        public static ChristofidesManager getManager(){
        	return instance;
        }
        
        public double[][] readDistanceMatrix(final String INPUT_FILE) throws IOException {
		double[][] matrix;
                BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
                
                StringBuilder build = new StringBuilder();
                // Find out how many cities there are in the file
                int numCities = 0;
                while (!build.append(br.readLine()).toString().equalsIgnoreCase("null")) {
                        numCities++;
                        build.setLength(0); // Clears the buffer
                }
                matrix = new double[numCities][numCities];
                // Reset reader to the start of the file
                br = new BufferedReader(new FileReader(INPUT_FILE));
                // Populate the distance matrix
                int currentCity = 0;
                build = new StringBuilder();
                while (!build.append(br.readLine()).toString().equalsIgnoreCase("null")) {
                        String[] tokens = build.toString().split(" ");
                        for (int i = 0; i < numCities; i++) {
                                matrix[currentCity][i] = Integer.parseInt(tokens[i]);
                        }
                        currentCity++;
                        build.setLength(0); // Clears the buffer
                }
                return matrix;
        }
        
        public void printMatrix(double [][] matrix) {
                for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                                System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                }
        }
}