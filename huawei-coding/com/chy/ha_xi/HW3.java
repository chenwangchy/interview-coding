package com.chy.ha_xi;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：最长平衡串 链接：https://www.neituiya.com/oj/18/322
 * 思路：把01串的前缀和求出来，对于任意区间[i, j]，如果是平衡串的话，有：s[j] - s[i - 1] = (j - i + 1) / 2
 * 两边同时乘以2，得到2* s[i - 1] -i + 1 = 2 * s[j] - j。
 * 在计算前缀和的时候，用哈希表存一下2 * s[i - 1] - i + 1，以及对应的i的下标。
 * 然后从小到大枚举j，看一下2 * s[j] - j 是否在哈希表中存在即可。如果存在，则长度 = j - i + 1，取最大值。
 * 初始化规则：当i=1，哈希表中存储 0，即初始化 (0, 1)
 */
public class HW3 {
    public int maxBalancedLength(String s) {
        int n = s.length();

        int[] sum = new int[n + 1];

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + s.charAt(i - 1) - '0';
            int key = 2 * sum[i - 1] - i + 1;
            int idx = map.getOrDefault(key, -1);
            if(idx == -1) {
                map.put(key, i);
            }
        }

        int res = 0;
        for(int j = 1; j <= n; ++j) {
            int sj = 2 * sum[j] - j;
            int i = map.getOrDefault(sj, j + 1);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
    
}
