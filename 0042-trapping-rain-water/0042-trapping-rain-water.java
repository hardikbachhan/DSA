class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lg = new int[n];
        int[] rg = new int[n];
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            lg[i] = max;
        }
        
        max = 0;
        for(int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rg[i]= max;
        }
        
        int waterContained = 0;
        for(int i = 0; i < n; i++) {
            int water = Math.min(lg[i], rg[i]) - height[i];
            if (water > 0) {
                waterContained += water;
            }
        }
        
        return waterContained;
    }
}