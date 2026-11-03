package com.chy.shuang_zhi_zhen;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：无重复字符的最长子串 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 * 思路：
 * 用双指针left, right两个指针维护一个区间，right向右移动的时候，如果发现新的字符，在之前出现过，那么直接让left跳转到之前出现过的位置 + 1
 * 用哈希表实时存储区间的字符下标
 */
public class LC3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0, right = 1;
        map.put(s.charAt(left), left);
        
        int res = 1;
        while(right < n) {
            char ch = s.charAt(right);
            int idx = map.getOrDefault(ch, -1);
            // 为什么是大于等于？因为没有设置删除区间哈希表存储的数据，所以需要通过下标来判断是否不在区间了
            if (idx >= left) {
                left = idx + 1;
            }
            res = Math.max(res, right - left + 1);
            map.put(ch, right++);
        }
        return res;
    }
    
}
