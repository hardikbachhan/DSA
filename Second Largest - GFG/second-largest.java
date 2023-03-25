//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        // code here
        
        int largestNum = Integer.MIN_VALUE;           //arr[0];
        int secondLargestNum = Integer.MIN_VALUE;     //-1;
        
        for (int i = 0; i < n; i++) {
            // if (arr[i] > largestNum) {
            //     // if (largestNum > secondLargestNum) {
            //     secondLargestNum = largestNum;
            //     // }
            //     largestNum = arr[i];
            // } else if (arr[i] < largestNum) {
            //     int diff1 = largestNum - arr[i];
            //     int diff2 = largestNum - secondLargestNum;
            //     if (diff1 < diff2) {
            //         secondLargestNum = arr[i];
            //     }
            // }
            int val = arr[i];
            
            if (val > largestNum) {
                secondLargestNum = largestNum;
                largestNum = val;
            } else if (val != largestNum && val > secondLargestNum) {
                secondLargestNum = val;
            }
        }
        
        if (secondLargestNum == Integer.MIN_VALUE) return -1;
        
        return secondLargestNum;
    }
}