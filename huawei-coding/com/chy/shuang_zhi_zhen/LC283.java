package com.chy.shuang_zhi_zhen;

/**
 * 题目：移动零 链接：https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 * 思路：枚举left，如果遇到0了，此时创建一个right指针向后搜索，找到一个非0的下标，然后交换一下即可。
 */
public class LC283 {

    public void moveZeroes(int[] nums) {
        
        int n = nums.length;
        
        
        for(int left = 0; left < n; ++left) {
            if(nums[left] != 0) continue;
            int right = left + 1;
            while(right < n && nums[right] == 0) ++right;
            if(right >= n) break;
            else {
                nums[left] = nums[right];
                nums[right] = 0;
            }
        }
    }
}
