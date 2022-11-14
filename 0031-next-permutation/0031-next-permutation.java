class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx1 = n - 1;
        boolean isFound = true;
        for(int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                isFound = false;
                break;
            }
        }
        
        if (isFound) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        int idx2 = n - 1;
        for(int i = n - 1; i > idx1; i--) {
            if (nums[i] > nums[idx1]) {
                idx2 = i;
                break;
            }
        }
        
        swap(nums, idx1, idx2);
        reverse(nums, idx1 + 1, n - 1);
    }
    
    public void swap(int[] nums, int idx1, int idx2) {
        int num1 = nums[idx1];
        int num2 = nums[idx2];
        nums[idx1] = num2;
        nums[idx2] = num1;
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int num = nums[end];
            nums[end] = nums[start];
            nums[start] = num;
            start++;
            end--;
        }
    }
}