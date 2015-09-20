pascals triangle
/*
每一行先置第一个数和最后一个数为1，中间的元素等于上一行两个元素的和，即：f[x][y] = f[x-1][y-1] + f[x-1][y]

reference:
http://codesniper.blogspot.com/2015/03/118-pascals-triangle-leetcode-java.html
Solution:
The pattern is clear. For any row, the first and last element is 1. 
For all other elements, the res[i][j]=res[i-1][j-1]+res[i-1][j], 
where i is the row number and j is the column number.
*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0){
            return res;
        }
        for(int i = 1; i <= numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i; j++){
                if(j == 0 || j == i-1){
                    list.add(1);
                }else{
                    list.add(res.get(i-2).get(j-1) + res.get(i-2).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}