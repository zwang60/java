spiral matrix  
这道题是比较简单的数组操作，按螺旋顺序把数组读取并且放到结果数组中即可。基本思路跟Rotate Image有点类似，就是一层一层的处
理，每一层都是按照右下左上的顺序进行读取就可以。实现中要注意两个细节，一个是因为题目中没有说明矩阵是不是方阵，因此要先判断一下行数和列数来确定螺旋的层数。另一个
是因为一层会占用两行两列，如果是单数的，最后要将剩余的走完。所以最后还要做一次判断。因为每个元素访问一次，所以时间复杂度是O(m*n)，m，n是分别是矩阵的行数
和列数，空间复杂度是O(1)。 
因为这道题是比较简单的题目，所以上面提到的两个细节还是比较重要的，面试中遇到了一定要注意，尽量做到没有bug哈。
reference: http://codeganker.blogspot.com/2014/03/spiral-matrix-leetcode.html

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return res;
        }
        int min = Math.min(matrix.length, matrix[0].length);
        int layer = min/2;
        for(int i = 0; i < layer; i++){
            for(int j = i; j < matrix[0].length - i - 1; j++){
                res.add(matrix[i][j]);
            }
            for(int j = i; j < matrix.length - i - 1; j++){
                res.add(matrix[j][matrix[0].length - 1 - i]);
            }
            for(int j = matrix[0].length - 1 - i; j > i; j--){
                res.add(matrix[matrix.length - 1 - i][j]);
            }
            for(int j = matrix.length - 1 - i; j > i; j--){
                res.add(matrix[j][i]);
            }
        }
        if(min%2 == 1){
            if(matrix.length < matrix[0].length){
                for(int i = layer; i < matrix[0].length - layer; i++){
                    res.add(matrix[layer][i]);
                }
            }else{
                for(int i = layer; i < matrix.length - layer; i++){
                    res.add(matrix[i][layer]);
                }
            }
        }
        return res;
    }
}