package com.chy.ha_xi;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：和等于 k 的最长子数组长度 链接：https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/
 * 思路：先求前缀和，枚举某个区间，s[i~j]，如果这个区间满足：s[j] - s[i - 1] = k，那么就表示这个区间符合
 * s[i - 1] = s[j] - k，s[i - 1]属于前缀和的某一项，所以用哈希表记录一下前缀和的每一项出现情况，
 * 然后贪心：既然要求最长，而且从小到大枚举，那么哈希表里面留出现最早的即可。k->前缀和项，v->这一项的下标
 * 计算时：枚举每个j，然后看 s[j] -k 是否存在，存在的话就求一次max(len, j - hash[s[j] - k])
 */
public class LC325 {

    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
            int idx = map.getOrDefault(sums[i], -1);
            if(idx == -1) {
                map.put(sums[i], i);
            }
        }
        int len = 0;
        for(int j = 1; j <= n; ++j) {
            int i = map.getOrDefault(sums[j] - k, j);
            len = Math.max(len, j - i);
        }
        return len;
    }
}
