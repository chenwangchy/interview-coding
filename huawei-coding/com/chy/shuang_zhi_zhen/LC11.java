package com.chy.shuang_zhi_zhen;

/**
 * 题目：盛最多水的容器 链接：https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 * 思路：相向指针，那边矮一点就移动那一边，符合单调性：w变小，那h小的那一边就要移动，期望能遇到更大的。
 */
public class LC11 {

    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        
        int res = 0;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            int water = h * (right - left);
            if(height[left] < height[right]) ++left;
            else --right;
            res = Math.max(res, water);
        }
        return res;
    }
    
}
