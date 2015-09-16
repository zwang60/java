merge sorted array
/*
维护三个index，分别对应两个数组最后一个元素和A数组的长度，这样从后往前扫两个数组，每次大的元素保存到A数组末尾，直到有一个数组到头。
如果A数组没到头不用特别处理，如果B数组没到头要把B对应的元素加到A数组
算法时间复杂度O(m+n)，空间复杂度O(1)。类似的题有merge two sorted lists, 面试中可能一起问到。
参考：
http://codeganker.blogspot.com/2014/02/merge-sorted-array-leetcode.html
*/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null){
            return;
        }
        int index = m+n-1, p1 = m-1, p2 = n-1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[index] = nums1[p1];
                p1--;
            }else{
                nums1[index] = nums2[p2];
                p2--;
            }
            index--;
        }
        while(p2 >= 0){
            nums1[index] = nums2[p2];
            p2--;
            index--;
        }
    }
}