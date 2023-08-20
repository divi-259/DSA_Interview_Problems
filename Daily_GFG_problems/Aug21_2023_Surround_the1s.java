/*
Problem Link: https://practice.geeksforgeeks.org/problems/surround-the-1s2505/1

Problem Statement: Given a matrix of order nxm, composed of only 0's and 1's, find the number of 1's in the matrix that are surrounded by an even number (>0) of 0's. 
The surrounding of a cell in the matrix is defined as the elements above, below, on left, on right as well as the 4 diagonal elements around the cell of the matrix. 
Hence, the surrounding of any matrix elements is composed of 8 elements. Find the number of such 1's.

Solution Approach: Traverse the matrix and for each element which is 1, check for its surroundings, and count the
number of zeros in there, update the total count if the number of zeros are even.

*/

/* ------------CODE---------------- */
class Solution
{
    public int dir[][] = {{1,1},{0,1},{1,0},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}};
    public int  Count(int[][] matrix)
    {
        int m = matrix.length; int n = matrix[0].length;
        int count = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                if(matrix[i][j] == 0)
                continue;
                int zcount = 0;
                for(int[] d : dir) {
                    int r = i+d[0];
                    int c = j+d[1];
                    if(r>=0 && r<m && c>=0 && c<n) {
                        if(matrix[r][c]==0)
                        zcount++;
                    }
                }
                if(zcount!=0 && zcount%2==0)
                count++;
                
            }
        }
        return count;
        
    }
}

/*
Time Complexity: O(m*n) 
Space Complexity: O(1) - we are not using any extra space just processing the matrix
*/