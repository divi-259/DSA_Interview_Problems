/*
Problem Link: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

Problem Statement: Given an unsorted array A of size N that contains only positive integers, find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing) of that subarray.

In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.

Solution Approach: Keep an index for the left side, intialize it to 0, now traverse the array from left to right,
if an answer is found - return that, otherwise reduce the current sum till it becomes less than the given sum,
and again check if the answer is found. If no answer found return the arraylist with -1 in it.

*/

/* ------------CODE---------------- */
class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        
        
        
        long sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        if(s==0) {
            ans.add(-1); 
            return ans;
        }
        int prev = 0;
        for(int i=0; i<n; i++) {
            sum = sum+arr[i];
            
            if(sum==s) {
                ans.add(prev+1); ans.add(i+1);
                return ans;
            }
            
            while(sum > s) {
                sum -= arr[prev++];
            }
            
            if(sum==s) {
                ans.add(prev+1); ans.add(i+1);
                return ans;
            }
        }
        
        ans.add(-1); 
        return ans;
    }
}

/*
Time Complexity: O(n) - need to traverse the entire array
Space Complexity: O(1) - we are only sending the first two indices found with sum of elements equal to given sum
*/