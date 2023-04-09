//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrixA = new int[n][n];
            int[][] matrixB = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrixA[i][j] = Integer.parseInt(S[j]);
            }
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrixB[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            ob.Mutliply(matrixA, matrixB);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(matrixA[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void  Mutliply(int[][] matrixA, int[][] matrixB)
    {
        // code here
        
        int nr1 = matrixA.length, nc1 = matrixA[0].length;
        int nr2 = matrixB.length, nc2 = matrixB[0].length;
        
        int[][] resMatrix = new int[nr1][nc2];
        
        for (int r = 0; r < resMatrix.length; r++) {
            for (int c = 0; c < resMatrix[r].length; c++) {
                int ans = 0;
                for (int k = 0; k < nc2; k++) {
                    ans += matrixA[r][k] * matrixB[k][c];
                }
                resMatrix[r][c] = ans;
            }
        }
        
        for (int r = 0; r < resMatrix.length; r++) {
            for (int c = 0; c < resMatrix[r].length; c++) {
                matrixA[r][c] = resMatrix[r][c];
            }
        }
        
    }
}