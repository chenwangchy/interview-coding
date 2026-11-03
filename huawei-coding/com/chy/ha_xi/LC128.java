package com.chy.ha_xi;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：最长连续序列 链接：https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 * 思路：用哈希表存一下以某个数开始的初始序列，求最长的序列，对于每个数，每次+1往下探索看是否存在，回溯的时候更新一下即可。
 */

public class LC128 {

    public int longestConsecutive(int[] nums) {


        Map<Integer, Integer> map = new HashMap<>();
        
        for(int x : nums) {
            map.put(x, 1);
        }
        for(int i = 0; i < nums.length; ++i) {
            add(map, nums[i]);
        }
        int max = 1;
        for(int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max;
    }
    
    int add(Map<Integer, Integer> map, int start) {
        int count = map.getOrDefault(start, 0);
        if(count == 0) return 0;
        if(count > 1) return count;
        int t = add(map, start + 1);
        map.put(start, map.get(start) + 1);
        return map.get(start);
    }
}
