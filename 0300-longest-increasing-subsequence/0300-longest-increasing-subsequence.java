class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        
        int[] dp = new int[n];
        dp[0] = 1;
        int LISLength = 1;
        
        for(int i = 0; i < n; i++) {
            int maxLen = 1;
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLen = Math.max(maxLen, dp[j] + 1);
                }
            }
            dp[i] = maxLen;
            LISLength = Math.max(dp[i], LISLength);
        }
        
        return LISLength;
    }
}