/*
Problem Link: https://leetcode.com/problems/move-zeroes/

Problem Statement: Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Solution Approach: Traverse the array from left to right, if you find a non zero element increase the start index and save it there.
Otherwise keep moving forward. After traversing the array - put the 0s from start index onwards till the end of the array.

*/

class Solution {
    public void moveZeroes(int[] nums) {

        int start = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                nums[start++] = nums[i];
            }
        }
        for(int i = start; i<nums.length; i++) {
            nums[i] = 0;
        }
        
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1) - we did not use any extra space, and modified the same array only
*/