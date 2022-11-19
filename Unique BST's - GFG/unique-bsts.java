//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    //Function to return the total number of possible unique BST.
    static int numTrees(int N) {
        if (N == 1) return 1;
        long[] dp = new long[N + 1];
        
        dp[0] = 1l;
        dp[1] = 1l;
        
        for(int i = 2; i < N + 1; i++) {
            long sum = 0l;
            
            int left = 0, right  = i - 1;
            while (left < i) {
                long ans = (long)((dp[left] * dp[right]) % 1000000007l);
                sum = (long)((sum + ans) % 1000000007l);
                left++;
                right--;
            }
            
            dp[i] = sum;
        }
        
        return (int)(dp[N] % 1000000007l);
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking n
            int n =sc.nextInt();
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling method numTrees() of 
            //class Solution
            System.out.println(ob.numTrees(n));
        }
    }
}

// } Driver Code Ends