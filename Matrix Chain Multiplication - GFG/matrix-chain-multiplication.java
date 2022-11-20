//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N - 1][N - 1];
        
        for(int gap = 0; gap < N - 1; gap++) {
            for(int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 0;
                } else if (gap == 1) {
                    dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int cut = i; cut < j; cut++) {
                        int lp = dp[i][cut];
                        int rp = dp[cut + 1][j];
                        int moper = arr[i] * arr[cut + 1] * arr[j + 1];
                        int total = lp + rp + moper;
                        min = Math.min(total, min);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}