package com.chy.shuang_zhi_zhen;

/**
 * 题目：可获得的最大点数 链接：https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/
 * 思路：头尾取卡片最大，本质上就是一段固定的区间和最小。
 */
public class LC1423 {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int w = n - k;
        int s = 0;
        int sum = 0;
        for(int i = 0; i < w; ++i) {
            s += cardPoints[i];
            sum += cardPoints[i];
        }
        int res = s;
        for(int i = w; i < n; ++i) {
            s += cardPoints[i];
            sum += cardPoints[i];
            s -= cardPoints[i - w];
            res = Math.min(res, s);
        }
        return sum - res;
    }
}
