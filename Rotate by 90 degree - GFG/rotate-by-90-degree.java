//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(st[k++]);
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix, n);
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n) 
    { 
        // code here
        for (int r = 0, c = 0; r < n && c < n; r++, c++) {
            for (int k = r + 1; k < n; k++) {
                int temp = matrix[r][k];
                matrix[r][k] = matrix[k][c];
                matrix[k][c] = temp;
            }
        }
        
        for (int c = 0; c < n; c++) {
            int sr = 0, er = n - 1;
            while (sr < er) {
                int temp = matrix[sr][c];
                matrix[sr][c] = matrix[er][c];
                matrix[er][c] = temp;
                sr++;
                er--;
            }
        }
    }
}