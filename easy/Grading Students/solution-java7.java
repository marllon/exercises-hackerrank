import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    
    private static int getNewGrade(int grade){
        if(grade <= 37)
            return grade;
        int nextMultiple = (grade/5+1)*5;
        if(nextMultiple - grade < 3)
            return nextMultiple;
        return grade;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());


        for (int i = 0; i < gradesCount; i++) {
            int gradesItem = Integer.parseInt(bufferedReader.readLine().trim());
            int newGrade = getNewGrade(gradesItem);
            bufferedWriter.write(String.valueOf(newGrade));
            bufferedWriter.newLine();
        }


        bufferedReader.close();
        bufferedWriter.close();
    }
}
