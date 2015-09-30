largest rectangle in histogram
/*
需要用到一个栈，每次元素大于栈顶元素就入栈，所以要维护一个递增栈。小于栈顶元素就出栈，并计算面积，更新最大面积，直到大于栈顶元素。
最后如果栈不为空，就出栈，如果栈空 area = height.length * height[index]，如果栈不为空 area = (height.length - stack.peek() - 1) * height[index];
*/
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < height.length; i++){
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int index = stack.pop();
                int area = stack.isEmpty() ? i * height[index] : (i - stack.peek() - 1) * height[index];
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            int area = stack.isEmpty() ? height.length * height[index] : (height.length - stack.peek() - 1) * height[index];
            max = Math.max(max, area);
        }
        return max;
    }
}