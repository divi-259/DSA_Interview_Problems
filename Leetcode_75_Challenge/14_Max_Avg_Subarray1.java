/*
Problem Link: https://leetcode.com/problems/maximum-average-subarray-i/

Problem Statement: You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Solution Approach: Use sliding window approach for k length window to get the sum, and update the maxavg after each iteration.

*/

/* ------------CODE---------------- */
class Solution {
    public double findMaxAverage(int[] nums, int k) {

        double sum = 0.0;
        double maxavg = Double.NEGATIVE_INFINITY;
        double curravg = 0.0;

        for(int i=0; i<k; i++) {
            sum += nums[i];
        }

        curravg = sum/k;
        maxavg = Math.max(curravg, maxavg);
        int prev = 0;
        for(int i=k; i<nums.length && prev<nums.length-k; i++) {
            sum = sum + nums[i] - nums[prev++];
            curravg = sum/k;
            maxavg = Math.max(curravg, maxavg);
        }

        return maxavg;
        
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/