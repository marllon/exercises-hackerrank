import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
    s: integer, starting point of Sam's house location.
    t: integer, ending location of Sam's house location.
    a: integer, location of the Apple tree.
    b: integer, location of the Orange tree.
    apples: integer array, distances at which each apple falls from the tree.
    oranges: integer array, distances at which each orange falls from the tree.
     */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);
        
        String[] applesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> apples = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesTemp[i]);
            int distanceFallen = a + applesItem;
            if(distanceFallen >= s && distanceFallen <= t)
                count++;
        }
        System.out.println(String.valueOf(count));
        count = 0;

        String[] orangesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");


        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesTemp[i]);
            int distanceFallen = b + orangesItem;
            if(distanceFallen >= s && distanceFallen <= t)
                count++;
        }
        System.out.println(String.valueOf(count));


        bufferedReader.close();
    }
}
