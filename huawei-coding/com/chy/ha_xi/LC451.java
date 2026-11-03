package com.chy.ha_xi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：根据字符出现频率排序 链接：https://leetcode.cn/problems/sort-characters-by-frequency/
 * 给定一个字符串 
 * s
 * s，请你根据字符出现的频率对其进行降序排序后返回。一个字符出现的频率是它在字符串中出现的次数。
 *
 * 若多个字符出现频率相同，按字符 ASCII 码从大到小排列（保证确定性输出）。
 */
public class LC451 {
    
    static class Node {
        char ch;
        int count;
        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i) {
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++count);
        }
        List<Node> list = new ArrayList<>();
        for(char ch : map.keySet()) {
            list.add(new Node(ch, map.get(ch)));
        }
        list.sort((a, b)->{
            if(a.count == b.count) return b.ch - a.ch;
            return b.count - a.count;
        });
        StringBuilder sb = new StringBuilder();
        list.forEach((a) -> {
            for(int i = 0; i < a.count; ++i) {
                sb.append(a.ch);
            }
        });
        return sb.toString();
    }
}
