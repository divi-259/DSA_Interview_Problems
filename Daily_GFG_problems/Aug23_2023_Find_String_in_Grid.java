/*
Problem Link: https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1

Problem Statement: Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. 
A word can be matched in all 8 directions at any point. 
Word is said to be found in a direction if all characters match in this direction 
(not in zig-zag form). 
The 8 directions are, horizontally left, horizontally right, vertically up, vertically down, and 4 diagonal directions.

Note: The returning list should be lexicographically smallest. 
If the word can be found in multiple directions starting from the same coordinates, 
the list should contain the coordinates only once. 

Solution Approach: 
For each cell where we are able to find the first character of the string, check for all directions
for that cell by using a separate method, if the word is found in any of the directions, add it to the ans list.
At the end put elements of ans list in an array and return the array.

*/

/* ------------CODE---------------- */
class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        
        // Only the square matrix will have the largest diagonal - of size of its rows or columns
        // Hence we can safely eliminate the case where word length is larger than matrix size
        if(word.length()>m && word.length()>n)
        return new int[0][0];
        
        List<int[]> ans = new ArrayList<>();
        int dir[][] = {{1,1},{-1,-1},{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,1}};
        // we kind of need to keep going into the same direction for a match
        // also we need to know if the remaining length of the matrix is enough for the word to be formed
        
        int index = 0; // index for traversing the string word
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // check for all directions if current char is equal to matrix[i][j]
                if(grid[i][j]==word.charAt(index)) {
                    boolean isCell = false;
                    for(int k=0; k<8; k++) {
                        if(checkDir(dir[k], grid, word, index+1, i, j))
                        {
                            isCell = true;
                            break;
                        }
                    }
                    // if we can get a word from this cell, add it to the answer
                    if(isCell) {
                        ans.add(new int[]{i,j});
                    }
                }
            }
        }
        
        int ret[][] = new int[ans.size()][2];
        for(int i=0; i<ret.length; i++) {
            ret[i][0] = ans.get(i)[0];
            ret[i][1] = ans.get(i)[1];
        }
        return ret;
    }
    
    private boolean checkDir(int[] d, char[][] grid, String word, int index, int r, int c) {
        
        int row = d[0] + r;
        int col = d[1] + c;
        
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length)
        return false;
        
        // keep checking for the remaining word in the same direction
        while(!(row<0 || col<0 || row>=grid.length || col>=grid[0].length) && index<word.length() && grid[row][col]==word.charAt(index)) {
            index++;
            row = row + d[0];
            col = col + d[1];
        }
        if(index==word.length())
        return true;
        
        else return false;
        
    }
}

/*
Time Complexity: O(m*n) (word.length) - we will keep traversing the while loop of checkDir at most word.length() times
Space Complexity: O(1) - we did not use any additional space, but if we take the ret array into consideration
then O(m*n) space will be taken.
*/