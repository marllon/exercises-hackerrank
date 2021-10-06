import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     
        - int n: the number of rows and columns in the board
        - nt k: the number of obstacles on the board
        - int r_q: the row number of the queen's position
        - int c_q: the column number of the queen's position
        - int obstacles[k][2]: each element is an array of  integers, the row and column of an obstacle
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, HashMap<String,String> obstacles) {
    // Write your code here
        int attacks = 0;
        if(n == 1)
            return attacks;    
            
        int x = c_q;
        int y = r_q;
        String[] directions = new String[]{"N", "NE", "E", "SE", "S", "SO", "O", "NO"};          
        //each incrementation would be based on the direction
        int increment_x = 0;
        int increment_y = 0;
        for(int i = 0; i < directions.length; i++){
            String direction = directions[i];
            if(direction.equals(""))
                continue;
            if(direction.equals("N")){
                increment_x = 0;
                increment_y = 1;                    
            } else if (direction.equals("NE")){
                increment_x = 1;
                increment_y = 1;
            } else if (direction.equals("E")){
                increment_x = 1;
                increment_y = 0;
            } else if (direction.equals("SE")){
                increment_x = 1;
                increment_y = -1;
            } else if (direction.equals("S")){
                increment_x = 0;
                increment_y = -1;
            } else if (direction.equals("SO")){
                increment_x = -1;
                increment_y = -1;
            } else if (direction.equals("O")){
                increment_x = -1;
                increment_y = 0;
            } else if (direction.equals("NO")){
                increment_x = -1;
                increment_y = 1;
            } 
            //the final x and y position would be based on queen's position
            int temp_x = x+increment_x;
            int temp_y = y+increment_y;
            while(true){
                //stop looping when "overlapping" the board limit
                if(temp_x < 1 || temp_x > n || temp_y < 1 || temp_y > n)
                {
                    directions[i] = "";
                    break;
                }
                String key = temp_x+","+temp_y;
                if(obstacles.containsKey(key)){
                    directions[i] = "";
                    break;
                }
                attacks++;    
                temp_x += increment_x;
                temp_y += increment_y;
            }              
        }
        return attacks;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        HashMap<String,String> hashMap = new HashMap<String,String>();

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            //adding obstacles to a hashmap
            String key = obstaclesRowTempItems[1]+","+obstaclesRowTempItems[0];
            hashMap.put(key, "");
        }

        int result = Result.queensAttack(n, k, r_q, c_q, hashMap);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
