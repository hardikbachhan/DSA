//{ Driver Code Starts
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
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int nr, int nc)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int rmin , cmin , rmax , cmax;
        rmin = cmin = 0;
        rmax = nr-1;
        cmax = nc-1;
        
        while(ans.size() < nr * nc) {
            // top wall
            for(int r = rmin , c = cmin ; c <= cmax && ans.size() < nr * nc ; c++){
                ans.add(matrix[r][c]);
            }
            
            // right wall
            for(int r = rmin+1 , c = cmax ; r <= rmax && ans.size() < nr * nc ; r++){
                ans.add(matrix[r][c]);
            }
            
            // bottom wall
            for (int r = rmax, c = cmax - 1; c >= cmin && ans.size() < nr * nc ; c--) {
                ans.add(matrix[r][c]);
            }
            
            // left wall
            for (int r = rmax - 1, c = cmin; r >= rmin + 1 && ans.size() < nr * nc ; r--) {
                ans.add(matrix[r][c]);
            }
            
            rmin++;
            cmin++;
            rmax--;
            cmax--;    
        }
        return ans;
    }
}
