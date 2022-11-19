//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}
// } Driver Code Ends



class Solution {
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        
        if (n == 0 || n == 1) return dp[n];
        
        for(int k = 2; k <= n; k++) {
            BigInteger sum = BigInteger.ZERO;
            int i = 0, j = k - 1;
            while (i < k) {
                sum = sum.add(dp[i].multiply(dp[j]));
                i++;
                j--;
            }
            dp[k] = sum;
        }
        
        return dp[n];
    }
}