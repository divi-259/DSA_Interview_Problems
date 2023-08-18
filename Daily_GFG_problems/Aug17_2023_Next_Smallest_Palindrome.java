/*

Problem Link: https://practice.geeksforgeeks.org/problems/next-smallest-palindrome4740/1

Problem Statement: Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive). The task is to find the next smallest palindrome strictly larger than the given number.

Solution Approach:
We need to consider three cases to solve this problem.
Case 1: when all the numbers in the arrary are digit 9, we can simply return 100..001 - kind of array

Case 2:The given number is already a palindrome. Here we will get two cases again, one where the middel number is 
not 9, and other where middle number is 9, then we need to take care of the case differently.

Case 3: Number is not a palindrome.
3.1: the left side is smaller than right side - then increase the middle element - and make the right side as palindrome, we 
can keep doing this by taking the two pointers if we get a carry by increasing the mid element and propagating the result to the right side 


Case 2 and 3 can be handled together, we will start from the middle and go to left and right till the numbers are same,
as soon as we find the numbers are not same, and the left side is also smaller, then increase the middle number,
if the left side is larger - then just replicate the left side on the right side.
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int nums[], int n) {
        // code here
        
        Vector<Integer> ans = new Vector<>();
        
        // -----------------------case 1 : all digits are 9 only--------------------------
        boolean isAllNine = true;
        for(int in=0; in<n; in++) {
            if(nums[in]!=9)
            {
                isAllNine = false;
                break;
            }
        }
        if(isAllNine) {
            ans.add(1);
            for(int in=1; in<n; in++) {
                ans.add(0);
            }
            ans.add(1);
            return ans;
        }
        
        
       // -------------Case 2 Input number is a palindrome----------------------------
       
        
        int mid = n/2;
        
        int i = mid-1; 
        int j = (n%2==0) ? mid : mid+1;
        
        // keep traversing if nums[i]==nums[j] - while the palindrome is there
        
        while(i>=0 && j<n) {
            if(nums[i]==nums[j]) {
                i--; j++;
            }
            else break;
        }
        
        // now we have the i and j where numbers are not equal
        
        boolean leftsmaller = false;
        // i<0 is for the cases where number is single digit, and then also we need to incrase the number
        if(i<0 || nums[i] < nums[j])
            leftsmaller = true; // now we know if we need to copy all left side elements directly or with some modification to them by increasing
        
        // copy left side elements to right side elements
        
        while(i>=0) {
            nums[j++] = nums[i--]; 
        }
        // check for the case if left side elements were smaller - then we need to increase the mid element and propagate the carry as well
        if(leftsmaller) {
            
            int carry = 1;
            
            if(n%2==1)
            {nums[mid] += carry;
            carry = nums[mid]/10;
            nums[mid] = nums[mid]%10;}
            
            i= mid-1;
            j = (n%2==0) ? mid : mid+1;
            
            while(i>=0 && carry>0) {
                nums[i] = nums[i] + carry;
                carry = nums[i]/10;
                nums[i] = nums[i]%10;
                nums[j] = nums[i]; i--; j++;
            }
            
        }
        
        
        for(int num : nums){
            ans.add(num);
        }
        
        return ans;
    }
}