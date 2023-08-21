/*
Problem Link: https://practice.geeksforgeeks.org/problems/make-matrix-beautiful-1587115620/1

Problem Statement: A beautiful matrix is a matrix in which the sum of elements in each row and column is equal. Given a square matrix of size NxN. Find the minimum number of operation(s) that are required to make the matrix beautiful. In one operation you can increment the value of any one cell by 1

Solution Approach: Get the sum of all rows and all columns in rowsum and colsum arrays.
Get the maxsum value in both of them, get the total operations by getting the difference for all the
rowsum's from the max value sum of the array.

*/

/* ------------CODE---------------- */
class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        int m = matrix.length;
        int n = matrix[0].length;
        int rowsum[] = new int[m];
        int colsum[] = new int[n];
        int maxval = 0;
        
        for(int i=0; i<m; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                sum+=matrix[i][j];
            }
            rowsum[i] = sum;
            maxval = Math.max(sum, maxval);
        }
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=0; j<m; j++) {
                sum+=matrix[j][i];
            }
            colsum[i] = sum;
            maxval = Math.max(sum, maxval);
        }
        
        int ops = 0;
        for(int i=0; i<rowsum.length; i++) {
            if(rowsum[i]!=maxval)
            ops += maxval-rowsum[i];
        }
        return ops;
    }
}
        

/*
Time Complexity: O(m*n)
Space Complexity: O(m) + O(n) - to store the sums for all rows and all cols
*/