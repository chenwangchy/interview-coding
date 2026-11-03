package com.chy.shuang_zhi_zhen;

/**
 * 题目：长度最小的子数组 链接：https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 * 思路：数组中都是正整数，那么前缀和一定递增。利用单调性，固定左指针，右指针不断向前遍历，如果发现某次满足和 >= target
 * 就尝试移动left，缩短这个区间，答案就藏在这个区间内。
 */
public class LC209 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        
        for(int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        int left = 1;
        int res = Integer.MAX_VALUE;
        for(int right = 1; right <= n; ++right) {
            while (left <= right && sums[right] - sums[left - 1] >= target) {
                res = Math.min(res, right - left + 1);
                ++left;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
