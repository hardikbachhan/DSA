//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDiagonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDiagonal(int N, int A[][])
    {
        // code here
        
        ArrayList<Integer> res = new ArrayList<>();
        
        
        int r = 0, nc = 0;
        
        while (true) {
            boolean flag = true;
            for (int c = nc; c >= 0; c--) {
                if (r >= 0 && r < N && c >= 0 && c < N) {
                    flag = false;
                    res.add(A[r][c]);
                }
                r++;
            }
            
            if (flag == true) {
                break;
            }
            
            r = 0;
            nc++;
        }
        
        return res;
    }
}
