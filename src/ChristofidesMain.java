import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;

/*
 *      Faisal Ejaz
 *      CS 331 - Algorithsm & Complexity
 *      Dr. Warnow
 *      TSP Heuristics
 *      Christofides Algorithm
 *     ChristofidesMain.java (runner)
 */

class ChristofidesMain{

        public static void main(String [] args){

                String command = "";
                Scanner input = new Scanner(System.in);
                long start = 0;
                long end = 0;

                // Christofides object intialization (in verbose mode)
                Christofides ch = null;
                try{
                        ch = new Christofides(true);
                }
                catch(Exception e){
                        e.printStackTrace();
                        System.exit(0);
                }

                while(true){
                        try{
                                // User input for input data file
                                System.out.print("specify input file [use \'./Datasets/\'] or type \'q\' to quit: ");
                                command = input.nextLine();

                                // Exit
                                if(command.equals("q"))
                                        break;

                                // Start timer
                                start = System.nanoTime();

                                // solve on specified input file 
                                int [] shortestPath = ch.solve(ChristofidesManager.getManager().readDistanceMatrix(command));

                                // Stop timer
                                end = System.nanoTime();

                                // print shortest path
                                System.out.println("Shortest path: "+Arrays.toString(shortestPath));

                                // print time
                                System.out.println("Time (in nano seconds): "+(end - start));

                                System.out.println("\n");
                        }
                        catch(Exception e){
                                e.printStackTrace();
                                System.out.println();
                        }
                }
        }
}
