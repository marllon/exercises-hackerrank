import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        Map<Character, Integer> count = new HashMap<>();
        for( char ch: a.toCharArray() ) {
            int ct = count.containsKey(ch) ? count.get(ch) : 0;
            count.put(ch, (ct + 1));
        }
        
        for( char ch: b.toCharArray() ) {
            int ct = count.containsKey(ch) ? count.get(ch) : 0;
            count.put(ch, (ct - 1));
        }
        
        List<Integer> values = new ArrayList<>(count.values());
        int deletions = 0;
        for(Integer v: values) {
            deletions += Math.abs(v);
        }
        return deletions;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
