class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int r = n - 1; r >= 0; r--) {
            for(int c = m - 1; c >= 0; c--) {
                char c1 = text1.charAt(r);
                char c2 = text2.charAt(c);
                
                if (c1 == c2) {
                    dp[r][c] = dp[r + 1][c + 1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c + 1]);
                }
            }
        }
        
        return dp[0][0];
    }
}