unique paths II
/*
找左右路径，用动归，
state: 
fuc: A[i][j]!=0, f[i][j] = f[i-1][j] + f[i][j-1]; A[i][j] = 0, f[i][j] = 0;
f[i] = f[i] + f[i-1]
init: 第一行，第一列，1之前都设成1，以后都是0
ans: f[m-1][n-1]
时间复杂度O(m*n), 空间O(n)
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    res[j] = 0;
                }else{
                    if(j != 0)
                        res[j] = res[j-1] + res[j];
                }
            }
        }
        return res[n-1];
    }
}