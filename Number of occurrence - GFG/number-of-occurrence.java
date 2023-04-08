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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    
    public static int firstOccurence(int[] arr, int x) {
        int sidx = 0, eidx = arr.length - 1;

        int possibleIdx = -1;

        while (sidx <= eidx) {
            int midIdx = (sidx + eidx) / 2;
            int midEle = arr[midIdx];

            if (midEle == x) {
                possibleIdx = midIdx;
                eidx = midIdx - 1;
            } else if (midEle < x) {
                sidx = midIdx + 1;
            } else if (midEle > x) {
                eidx = midIdx - 1;
            }
        }

        return possibleIdx;
    }

    public static int lastOccurence(int[] arr, int x) {
        int sidx = 0, eidx = arr.length - 1;
        int possibleIdx = -1;
        while (sidx <= eidx) {
            int midIdx = (sidx + eidx) / 2;
            int midEle = arr[midIdx];

            if (midEle == x) {
                possibleIdx = midIdx;
                sidx = midIdx + 1;
            } else if (midEle < x) {
                sidx = midIdx + 1;
            } else if (midEle > x) {
                eidx = midIdx - 1;
            }
        }

        return possibleIdx;
    }
    
    int count(int[] arr, int n, int x) {
        // code here
        
        int fo = firstOccurence(arr, x);
        
        if (fo == -1) return 0;
        
        int lo = lastOccurence(arr, x);
        
        return lo - fo + 1;
    }
}