spiral matrix II 
/* 
这道题跟Spiral Matrix很类似，只是这道题是直接给出1到n^2，然后把这些数按照螺旋顺序放入数组中。思路跟Spiral
Matrix还是一样的，就是分层，然后按照上右下左的顺序放入数组中。每个元素只访问一次，时间复杂度是O(n^2)。 

reference:
http://codeganker.blogspot.com/2014/03/spiral-matrix-ii-leetcode.html
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n <= 0){
            return res;
        }
        int num = 1, layer = n/2;
        for(int i = 0; i < layer; i++){
            for(int j = i; j < n-i; j++){
                res[i][j] = num++;
            }
            for(int j = i+1; j < n-i; j++){
                res[j][n-1-i] = num++;
            }
            for(int j = n-2-i; j >= i; j--){
                res[n-1-i][j] = num++;
            }
            for(int j = n-2-i; j > i; j--){
                res[j][i] = num++;
            }
        }
        if(n%2 == 1){
            res[layer][layer] = num;
        }
        return res;
    }
}