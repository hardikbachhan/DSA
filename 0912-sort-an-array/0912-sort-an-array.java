class Solution {
    
    public int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        
        int[] sortedArray = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                sortedArray[k] = a[i];
                i++;
                k++;
            } else if (b[j] < a[i]) {
                sortedArray[k] = b[j];
                j++;
                k++;
            } else if (a[i] == b[j]) {
                sortedArray[k] = a[i];
                k++;
                sortedArray[k] = b[j];
                k++;
                i++;
                j++;
            }
        }
        
        while (i < a.length) {
            sortedArray[k] = a[i];
            i++;
            k++;
        }
        
        while (j < b.length) {
            sortedArray[k] = b[j];
            j++;
            k++;
        }
        
        return sortedArray;
    }
    
    public int[] mergeSort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            int[] base = new int[1];
            base[0] = nums[lo];
            // System.out.println(lo + " " + hi + " " + Arrays.toString(base));
            return base;
        }
        
        int mid = (lo + hi) / 2;
        
        int[] firstSortedHalf = mergeSort(nums, lo, mid);
        int[] secondSortedHalf = mergeSort(nums, mid + 1, hi);
        int[] sortedArray = mergeTwoSortedArrays(firstSortedHalf, secondSortedHalf);
        // System.out.println(lo + " " + hi + " " + Arrays.toString(sortedArray));
        return sortedArray;
    }
    
    public int[] sortArray(int[] nums) {
        int[] ans = mergeSort(nums, 0, nums.length - 1);
        return ans;
    }
}