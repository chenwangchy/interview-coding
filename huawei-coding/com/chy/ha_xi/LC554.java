package com.chy.ha_xi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：砖墙 链接：https://leetcode.cn/problems/brick-wall/
 * 思路：把每一块砖的右边界看做是间隙，统计所有行的间隙，用哈希表存储起来，这样枚举哈希表的每个间隙，就能知道穿过的砖头数了
 */
public class LC554 {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int s = 0;
            for(int i = 0; i < list.size() - 1; ++i) {
                s += list.get(i);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int res = wall.size();
        for(int gap : map.keySet()) {
            res = Math.min(res, wall.size() - map.get(gap));
        }
        return res;
    }
}
