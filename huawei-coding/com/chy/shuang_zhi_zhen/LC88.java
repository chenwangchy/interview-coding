package com.chy.shuang_zhi_zhen;

/**
 * 题目：合并两个有序数组 链接：https://leetcode.cn/problems/merge-sorted-array/description/
 * 思路：维护两个指针和一个下标。哪一个指针对应的数大，就将这个数填充到对应的下标，同时对应的指针 --，下标--
 * 然后扫描一下nums2剩余的内容即可。
 */
public class LC88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int idx = m + n - 1;
        
        int p1 = m - 1, p2 = n - 1;
        
        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] <= nums2[p2]) {
                nums1[idx --] = nums2[p2--];
            }else {
                nums1[idx --] = nums1[p1--];
            }
        }
        while(p2 >= 0) {
            nums1[idx --] = nums2[p2 --];
        }
    }
}
