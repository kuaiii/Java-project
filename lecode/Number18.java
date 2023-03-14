package lecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                int twotarget = target - nums[i]- nums[j];
                int low = j+1, high = nums.length-1;
                while(low <= high){
                    int temp = nums[low] + nums[high];
                    if(temp == twotarget){
                        List<Integer> suc = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                        ret.add(suc);
                        int dis1 = nums[low+1] - nums[low], dis2 = nums[high] - nums[high-1];
                        if(dis1 < dis2){
                            low++;
                        } else{
                            high--;
                        }
                    } else if(temp < twotarget){
                        low++;
                    } else{
                        high--;
                    }
                }
            }
        }
        return ret;
    }
}
