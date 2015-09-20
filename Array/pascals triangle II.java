pascals triangle II
/*
跟1一样，但是处理每行0和i-1的时候要特别注意，这题还有给的行数是从0开始的。
list有两个方法，set，add要特别注意

reference：
http://codesniper.blogspot.com/search?q=pascal
Solution:
This is a extension problem of the previous problem: Pascal's Triangle
The difficulty of this problem is to use only O(k) extra space.
We know that res[i][j]=res[i-1][j-1]+res[i-1][j], so if we iterate j from back to front, which will update jth column first and then (j-1)th. 
This is very important, because when we calculate res[i][j], we need res[i-1][j-1] rather than res[i][j-1]. 
So in this way, we don't have to use extra space to store res[i-1][j-1]. 
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0){
            return res;
        }
        res.add(1);
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i-1; j >= 1; j--){
                res.set(j, res.get(j-1) + res.get(j));
            }
            res.add(1);
        }
        return res;
    }
}