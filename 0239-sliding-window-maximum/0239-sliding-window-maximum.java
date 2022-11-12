class Solution {
    
    public int[] NGER(int[] nums) {
        int[] nger = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i = nums.length - 1; i >= 0; i--) {
            while (s.size() > 0 && nums[i] > nums[s.peek()]) {
                s.pop();
            }
            if (s.size() == 0) {
                nger[i] = nums.length;
            } else {
                nger[i] = s.peek();
            }
            s.push(i);
        }
        // System.out.println(Arrays.toString(nger));
        return nger;
    }
    
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nger = NGER(nums);
        int[] ans = new int[nums.length - k + 1];
        int sidx = 0;
        int gidx = 0;
        while (sidx <= nums.length - k) {
            if (gidx < sidx) {
                gidx = sidx;
            }
            while (nger[gidx] < sidx + k) {
                gidx = nger[gidx];
            }
            ans[sidx] = nums[gidx];
            sidx++;
        }
        return ans;
    }
}