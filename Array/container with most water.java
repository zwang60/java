container with most water
/*
同类型题：two sum, trapping rain water, 
另易混淆的一类题：Longest Valid Parentheses, Largest Rectangle in Histogram, Maximal Rectangle,
区别在于之前一类只需要考虑两边高度，后面一类要考虑中间高度是否大于等于两边高度。
所以前面一类多用two pointer的方法，向中间夹逼，后面一类多用递增栈来辅助。

reference:
http://codeganker.blogspot.com/2014/02/container-with-most-water-leetcode.html
首先一般我们都会想到brute force的方法，思路很简单，
就是对每一对pair都计算一次容积，然后去最大的那个，总共有n*(n-1)/2对pair，所以时间复杂度是O(n^2)。 

接下来我们考虑如何优化。思路有点类似于Two Sum中的第二种方法--夹逼。

从数组两端走起，每次迭代时判断左pointer和右pointer指向的数字哪个大，

如果左pointer小，意味着向左移动右pointer不可能使结果变得更好，因为瓶颈在左pointer，移动右pointer只会变小，所以这时候我们选择左pointer右移。

反之，则选择右pointer左移。在这个过程中一直维护最大的那个容积。

以上的算法，因为左pointer只向右移，右pointer只向左移，直到相遇为止，所以两者相加只走过整个数组一次，时间复杂度为O(n),空间复杂度是O(1)。
该算法利用了移动指针可确定的规律，做了一步贪心，实现了时间复杂度的降低。
*/
public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int l = 0, r = height.length - 1, max = Integer.MIN_VALUE;
        while(l < r){
            int area = 0;
            if(height[l] < height[r]){
                area = (r-l)*height[l];
                l++;
            }else{
                area = (r-l)*height[r];
                r--;
            }
            max = Math.max(max, area);
        }
        return max;
    }
}