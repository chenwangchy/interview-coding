package com.chy.ha_xi;

import java.util.*;

/**
 * 题目：数组交集 链接：https://www.neituiya.com/oj/18/894
 */
public class HW2 {

    public int[] intersection(int[] a, int[] b) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        for(int x : a) set1.add(x);
        for(int x : b) set2.add(x);
        for(int x : set1) {
            if(set2.contains(x)) list.add(x);
        }
        list.sort((x, y) -> x - y);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }
}
