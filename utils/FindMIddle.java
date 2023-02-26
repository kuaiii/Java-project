package utils;

import javax.xml.stream.events.StartDocument;

public class FindMIddle {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double x1 = findMid(nums1, nums2, 0, 0, (nums1.length+nums2.length+1)/2);
        double x2 = findMid(nums1, nums2, 0, 0, (nums1.length+nums2.length+2)/2);
        return (x1 + x2)/2;
    }
    public double findMid(int[] nums1, int[] nums2, int low1, int low2, int num){
        if(low1 == nums1.length)   return nums2[low2+num-1];
        else if(low2 == nums2.length)   return nums1[low1+num-1];
        else if(num == 1)    return nums1[low1]<nums2[low2] ? nums1[low1]:nums2[low2];
        else{
            int site = num/2;
            int high1 = (low1+site)>nums1.length ? nums1.length-1:low1+site-1;
            int high2 = (low2+site)>nums2.length ? nums2.length-1:low2+site-1;
            if(nums1[high1] < nums2[high2]){
                return findMid(nums1, nums2, high1+1, low2, num-high1+low1-1);
            } else{
                return findMid(nums1, nums2, low1, high2+1, num-high2+low2-1);
            }
        }
    }
    public static void main(String[] args){
        int[] nums1 = {1, 3}, nums2 = {2, 7};
        FindMIddle x = new FindMIddle();
        double ret = x.findMedianSortedArrays(nums1, nums2);
        System.out.println(ret);
    }
}
