triangle *
/*
动归问题
state：
func：f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + A[i][j];
init：f[n-1][j]
ans：f[0][0]
*/
//从下到上动归
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] f = new int[m][n];
        for(int i = 0; i < n; i++){
            f[m-1][i] = triangle.get(m-1).get(i);
        }
        for(int i = m-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return f[0][0];
    }
}
//记忆化搜索
