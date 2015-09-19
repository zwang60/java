set matrix zeroes
/*
用两个数组分别记录行和列，如果这一行没被置为1，就扫描这一行，否则继续下一行，如果这一列没被置为1，就扫描这一列，否则继续下一列
碰到0，如果这个行或者列没被置为1，就把它们分别置为1，
最后扫描两个数组，对应位置为1的行或者列都置为0

reference:
http://codeganker.blogspot.com/2014/04/set-matrix-zeroes-leetcode.html
这是一个矩阵操作的题目，目标很明确，就是如果矩阵如果有元素为0，就把对应的行和列上面的元素都置为0。这里最大的问题就是我们遇到0的时候不能直接把矩阵的行列在当前矩阵直接置0，否则后面还没访问到的会被当成原来是0，最后会把很多不该置0的行列都置0了。
一个直接的想法是备份一个矩阵，然后在备份矩阵上判断，在原矩阵上置0，这样当然是可以的，不过空间复杂度是O(m*n)，不是很理想。
上面的方法如何优化呢？我们看到其实判断某一项是不是0只要看它对应的行或者列应不应该置0就可以，所以我们可以维护一个行和列的布尔数组，然后扫描一遍矩阵记录那一行或者列是不是应该置0即可，后面赋值是一个常量时间的判断。这种方法的空间复杂度是O(m+n)。
其实还可以再优化，我们考虑使用第一行和第一列来记录上面所说的行和列的置0情况，这里问题是那么第一行和第一列自己怎么办？想要记录它们自己是否要置0，只需要两个变量（一个是第一行，一个是第一列）就可以了。然后就是第一行和第一列，如果要置0，就把它的值赋成0（反正它最终也该是0，无论第一行或者第一列有没有0），否则保留原值。然后根据第一行和第一列的记录对其他元素进行置0。最后再根据前面的两个标记来确定是不是要把第一行和第一列置0就可以了。这样的做法只需要两个额外变量，所以空间复杂度是O(1)。
时间上来说上面三种方法都是一样的，需要进行两次扫描，一次确定行列置0情况，一次对矩阵进行实际的置0操作，所以总的时间复杂度是O(m*n)。
这道题也是cc150里面比较经典的题目，看似比较简单，却可以重重优化，最终达到常量空间。其实面试中面试官看重的是对于算法时间空间复杂度的理解，对优化的概念，这些常常比题目本身的难度更加重要，平常做题还是要对这些算法分析多考虑哈。
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        boolean row = false;
        boolean col = false;
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                row = true;
                break;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                col = true;
                break;
            }
        }
        for(int i = 1; i < matrix[0].length; i++){
            for(int j = 1; j < matrix.length; j++){
                if(matrix[j][i] == 0){
                    matrix[0][i] = 0;
                    matrix[j][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix[0].length; i++){
            for(int j = 1; j < matrix.length; j++){
                if(matrix[0][i] == 0 || matrix[j][0] == 0){
                    matrix[j][i] = 0;
                }
            }
        }
        if(row == true){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if(col == true){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}