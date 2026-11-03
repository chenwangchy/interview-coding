package com.chy.ha_xi;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：单词规律 链接：https://www.neituiya.com/oj/18/3531
 * 思路：pattern中的字符用哈希表存储，s中的单词也用哈希表存储，然后遍历p，得到次数和次数的出现次数的哈希表
 * 同理遍历S，最后比较次数出现的次数是否完全一致即可。
 * 举个例子：p中：a:2, b:3, c: 2 => 哈希表中：2: 2, 3: 1
 * S中：dog:2, cat: 2, fish: 3 => 哈希表中：3: 1, 2: 2
 *
 */
public class HW1 {

    public boolean wordPattern(String pattern, String s) {

        Map<Character, Integer> pMap = new HashMap<>();
        Map<String, Integer> sMap = new HashMap<>();
        
        String[] split = s.split(" ");
        for(int i = 0; i < pattern.length(); ++i) {
            char ch = pattern.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        for(String t : split) {
            sMap.put(t, sMap.getOrDefault(t, 0) + 1);
        }
        System.out.println(pMap);
        System.out.println(sMap);
        
        Map<Integer, Integer> countPMap = new HashMap<>(), countSMap = new HashMap<>();
        
        put(countPMap, pMap);
        put(countSMap, sMap);

        System.out.println(countPMap);
        System.out.println(countSMap);
        
        for(int key : countPMap.keySet()) {
            if(countSMap.get(key) == null) return false;
            if(countSMap.get(key) != countPMap.get(key)) {
                System.out.println(countSMap.get(key) + "  " + countPMap.get(key));
                return false;
            }
        }
        return true;
        
    }
    
    <T>void put(Map<Integer, Integer> countMap, Map<T, Integer> map) {
        for(T key : map.keySet()) {
            countMap.put(map.get(key), countMap.getOrDefault(map.get(key), 0) + 1);
        }
    }
    
}
