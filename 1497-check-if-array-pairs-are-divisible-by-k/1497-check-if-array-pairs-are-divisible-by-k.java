class Solution {
    public boolean canArrange(int[] arr, int k) {
        if (arr.length % 2 != 0) return false;
        
        HashMap <Integer, Integer> freqMap = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            if (rem < 0) {
                rem += k;
            }
            if (freqMap.containsKey(rem) == false) {
                freqMap.put(rem, 1);
            } else {
                freqMap.put(rem, freqMap.get(rem) + 1);
            }
        }
        
        
        for(Integer rem: freqMap.keySet()) {
            if (rem == 0) {
                if (freqMap.get(rem) % 2 != 0) {
                    return false;
                }
            } else if (rem * 2 == k) {
                if (freqMap.get(rem) % 2 != 0) {
                    return false;
                }
            } else {
                int freq1 = freqMap.get(rem);
                int freq2 = freqMap.getOrDefault(k - rem, 0);
                if (freq1 != freq2) {
                    return false;
                }
                // if (freqMap.containsKey(k - rem) == true) {
                //     if (freqMap.get(rem) != freqMap.get(k - rem)) {
                //         return false;
                //     }
                // } else {
                //     return false;
                // }
            }
        }
        return true;
    }
}