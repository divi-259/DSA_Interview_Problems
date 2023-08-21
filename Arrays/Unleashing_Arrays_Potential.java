/*
Problem Link: This problem was part of gfg contest named as - Unleashing the Array's Potential


Problem Statement: Given an array arr[ ] consisting of n integers, find the maximum Geek Value of the array to unleash its true potential. 

Geek value is defined as (arri - arrj) × arrk, where 1 ≤ i < j < k ≤ n. 

Please note that if the Geek Value turns out to be negative, return 0 as the answer. 

Solution Approach: 
We need to get the prefixMax and suffixMax arrays and then we can traverse the array once again for all the j's values,
keep storing the max Geek value in a variable and update it while traversing the array.

*/

/* ------------CODE---------------- */

class Solution{
    public long maxValue(int n, int arr[]){
        // Code Here. 
        
        // get prefix max and suffix max array
        
        long[] prefixMax = new long[n];
        long suffixMax[] = new long[n];
        
        prefixMax[0] = arr[0];
        for(int i=1; i<n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);
        }
        
        suffixMax[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], arr[i]);
        }
        
        // Now traverse the array and get the max for each index
        
        long maxGeek = 0;
        for(int i=1; i<=n-2; i++) {
            maxGeek = Math.max(maxGeek, (prefixMax[i-1]-arr[i]) * suffixMax[i+1]);
        }
        
        return maxGeek;
        
    }
}
/*
Time Complexity: O(n) - we are traversing the main array only three times - O(n) + O(n) +O(n)
Space Complexity: O(n) - we need extra storage space for prefix and suffix max arrays
*/