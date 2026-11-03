package com.chy.ha_xi;


import java.util.HashMap;
import java.util.Map;

/**
 * 题目：拼写单词 链接：https://leetcode.cn/problems/find-words-that-can-be-formed-by-characters/
 * 思路：哈希表存储chars，然后枚举每个单词即可
 */
public class LC1160 {
    public int countCharacters(String[] words, String chars) {

        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < chars.length(); ++i) {
            char ch = chars.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int res = 0;
        for(String word : words) {
            Map<Character, Integer> tmp = new HashMap<>();
            for(int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                tmp.put(ch, tmp.getOrDefault(ch, 0) + 1);
            }
            boolean flag = true;
            for(char ch : tmp.keySet()) {
                if(tmp.get(ch) > map.getOrDefault(ch, 0)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res += word.length();
            }
        }
        return res;
        
    }
}
