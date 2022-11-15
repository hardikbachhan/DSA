class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        int maxVal = Integer.MIN_VALUE;
        for(int num: nums) {
            maxVal = Math.max(num, maxVal);
            h.add(num);
        }
        if (h.size() < 3) {
            return maxVal;
        }
        
        maxVal = Integer.MIN_VALUE;
        int midVal = Integer.MIN_VALUE;
        int minVal = Integer.MIN_VALUE;
        for(int val: h) {
            if (val >= maxVal) {
                minVal = midVal;
                midVal = maxVal;
                maxVal = val;
            } else if (val < maxVal && val >= midVal) {
                minVal = midVal;
                midVal = val;
            } else if (val < midVal && val >= minVal) {
                minVal = val;
            }
        }
        return minVal;
    }
    
//     public int thirdMax(int[] nums) {
//         // iterate over all elems of nums
        
//         HashSet<Integer> h = new HashSet<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
//             return y - x;
//         });
        
//         for(int num: nums) {
//             // if elem is not present in hashset
//             if (h.contains(num) == false) {
//                 // add elem in priority queue
//                 pq.add(num);
//                 // add elem in hashset
//                 h.add(num);
//             }
//         }
//         int counter = 1;
//         int maxVal = pq.remove();
//         int ans = maxVal;
//         while (pq.size() > 0 && counter < 3) {
//             // remove 3 elems from priority queue
//             // third elem is the ans
//             // if 3 elems cannot be removed return last value removed from priority queue
//             counter++;
//             ans = pq.remove();
//         }
        
//         if (counter < 3) {
//             return maxVal;
//         }
//         // incase the 3rd max distinct number doesnot exist we will return max number of whole array
        
//         return ans;
//     }
}