search a 2D matrix
/*
这题有个小技巧，用到了number of islands题中id和坐标转换的方法，id = x*m + y(m是一行的长度)
用这种方法将二维矩阵转换成一维数组，对一维数组binary search找target，时间复杂度O(log(m*n))，也就是O(logm + logn)
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix[0].length, n = matrix.length;
        int left = 0, right = m*n-1, mid;
        while(left + 1 < right){
            mid = (left + right)/2;
            int row = mid/m, col = mid%m;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(matrix[left/m][left%m] == target){
            return true;
        }
        if(matrix[right/m][right%m] == target){
            return true;
        }
        return false;
    }
}