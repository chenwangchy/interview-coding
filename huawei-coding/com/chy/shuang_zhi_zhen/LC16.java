package com.chy.shuang_zhi_zhen;

import java.util.Arrays;

/**
 * 题目：最接近的三数之和 链接：https://leetcode.cn/problems/3sum-closest/
 * 思路：先排序，然后枚举i，定义两个指针j和k，分类讨论：s == target、s < 0,target。。。。。
 */
public class LC16 {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i <= n - 3; ++i) {
            int j = i + 1, k = n - 1;
            while(j < k) {
                int s = nums[i] + nums[j] + nums[k];
//                System.out.println(s);
                if(s == target) {
                    return s;
                }
                if((s == 0 && target > 0) || (s > 0 && target > 0 && s < target) || (s < 0 && target >= 0) || (s < 0 && target < 0 && s < target)) {
                    ++j;
                }else {
                    --k;
                }
                
                int abs = Math.abs(s - target);
                if(diff >= abs) {
                    diff = abs;
                    res = s;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC16 lc16 = new LC16();
        int[] nums = {-1,2,1,-4};
        System.out.println(lc16.threeSumClosest(nums, 1));
    }
}
