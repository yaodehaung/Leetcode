package com.fishercoder.solutions;

public class _485 {
    public static class Solution1 {
        public int findMaxConsecutiveOnes(int[] nums) {
            int maxLen = 0;
            for (int i = 0; i < nums.length; i++) {
                int currentLen = 0;
                while (i < nums.length && nums[i] == 1) {
                    i++;
                    currentLen++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
            return maxLen;
        }
    }

    // time space O(n)
    public static class Solution2 {

        public int findMaxConsecutiveOnes(int[] nums){
            int maxLen = 0;
            int currentLen = 0;

            for(int i = 0 ; i < nums.length; i++){
                if(nums[i] == 1){
                    currentLen++;
                    if(maxLen < currentLen ){
                        maxLen = currentLen;
                    }
                }else{
                    currentLen = 0;
                }
            }

            return maxLen;
        }
    }

    // Sliding Window Solution
    public static class Solution3{

    }
}
