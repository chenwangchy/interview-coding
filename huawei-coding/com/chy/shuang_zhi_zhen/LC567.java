package com.chy.shuang_zhi_zhen;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：字符串的排列 链接
 */
public class LC567 {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int n = s1.length();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < n; ++i) {
            char ch1 = s1.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
            char ch2 = s2.charAt(i);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }
        if(check(map1, map2)) return true;
        for(int j = n; j < s2.length(); ++j) {
            char suffix = s2.charAt(j), prev = s2.charAt(j - n);
            map2.put(suffix, map2.getOrDefault(suffix, 0) + 1);
            map2.put(prev, Math.max(map2.getOrDefault(prev, 0) - 1, 0));
            if(check(map1, map2)) return true;
        }
        return false;
    }
    boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for(char key : map1.keySet()) {
            if(map2.getOrDefault(key, 0).intValue() != map1.get(key).intValue()) return false;
        }
        return true;
    }
}
