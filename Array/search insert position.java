search insert position
/*
在数组中查找target的问题，就是用二分法，时间复杂度O(logn)，空间复杂度O(1)
但是要特别注意边界条件：target小于第一个元素，返回0，大于最后一个元素，返回length，
如果target在数组中，返回index，如果不在数组中，返回start或end大于target小的那个

reference: http://blog.csdn.net/linhuanmars/article/details/20278967  注意以上实现方式有一
个好处，就是当循环结束时，如果没有找到目标元素，那么l一定停在恰好比目标大的index上，r一定停在恰好比目标小的index上，所以个人比较推荐这种实现方式。
二分查找是一个非常经典的方法，不过一般在面试中很少直接考二分查找，会考一些变体，例如Search in Rotated Sorted Array，Search
for a Range和Search a 2D Matrix，思路其实是类似的，稍微变体一下即可，有兴趣可以练习一下哈。 
*/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(target < nums[0]){
            return 0;
        }
        if(target > nums[nums.length - 1]){
            return nums.length;
        }
        int start = 0, end = nums.length - 1, mid;
        while(start + 1 < end){
            mid = (start + end)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                end = mid;
            }else if(target > nums[mid]){
                start = mid;
            }
        }
        if(nums[start] >= target){
            return start;
        }
        return end;
    }
}

ps: 二分法边界处理有两种方法：
start + 1 < end
if(target == nums[mid]){
    return mid;
}else if(target < nums[mid]){
    end = mid;
}else if(target > nums[mid]){
    start = mid;
}
if(nums[start] >= target){
    return start;
}
return end;
这种方法比较好理解，但是要处理的边界情况比较多
还有一种方法如下，也是比较好的写法：
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int l = 0;
        int r = nums.length-1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]<target)
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
    }
}