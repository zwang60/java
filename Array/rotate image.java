rotate image /* reference: http://46aae4d1e2371e4aa769798941cef698.devproxy.yu
nshipei.com/linhuanmars/article/details/21503683 这道题虽然操作起来有一点繁琐，但是思路比较简单，就是考察一
下数组的基本操作。基本思路是把图片分为行数/2层，然后一层层进行旋转，每一层有上下左右四个列，然后目标就是把上列放到右列，右列放到下列，下列放到左列，左列放
回上列，中间保存一个临时变量即可。因为每个元素搬运的次数不会超过一次，时间复杂度是O(矩阵的大小)，空间复杂度是O(1)。 
这种题目就是思路比较简单，不过实现的时候要细心，容易出错。如果面试遇到了还得谨慎对待，尽量不要出错哈。
*/
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return;
        }
        int layernum = matrix.length/2;
        for(int layer = 0; layer < layernum; layer++){
            for(int i = layer; i < matrix.length - 1 - layer; i++){
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[matrix.length - 1 - i][layer];
                matrix[matrix.length - 1 - i][layer] = matrix[matrix.length - 1 - layer][matrix.length - 1 - i];
                matrix[matrix.length - 1 - layer][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - layer];
                matrix[i][matrix.length - 1 - layer] = temp;
            }
        }
    }
}