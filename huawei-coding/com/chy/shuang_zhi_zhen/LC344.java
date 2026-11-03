package com.chy.shuang_zhi_zhen;

/**
 * 题目：反转字符串 链接：https://leetcode.cn/problems/reverse-string/
 * 
 */
public class LC344 {

    public void reverseString(char[] s) {
        
        int left = 0, right = s.length - 1;
        char t;
        while(left < right) {
            t = s[left];
            s[left ++] = s[right];
            s[right --] = t;
        }
    }
}
