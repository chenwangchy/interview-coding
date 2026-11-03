package com.chy.shuang_zhi_zhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        
        int n = nums.length;
        for(int i = 0; i < n; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            
            int a = nums[i];
            int j = i + 1, k = n - 1;
            while(j < k) {
                int b = nums[j], c = nums[k];
                int s = a + b + c;
                if(s> 0) {
                    --k;
                }else if(s < 0) {
                    ++j;
                }else {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    res.add(list);
                    while(j < k && nums[j] == nums[j + 1]) ++j;
                    while(j < k && nums[k] == nums[k - 1]) --k;
                    ++j;
                    --k;
                }
            }
        }
        
        return res;
    }
}
