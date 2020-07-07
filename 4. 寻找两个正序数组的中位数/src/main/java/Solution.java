import org.junit.jupiter.api.Test;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *  
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int length = nums.length;
        for(int i = 0, j = 0, k = 0, len1 = nums1.length, len2 = nums2.length; k < length;){
            if(i >= len1){
                nums[k] = nums2[j];
                j++;
                k++;
            }else if(j >= len2){
                nums[k] = nums1[i];
                i++;
                k++;
            }else if(nums1[i] <= nums2[j]){
                nums[k] = nums1[i];
                i++;
                k++;
            }else if(nums2[j] <= nums1[i]){
                nums[k] = nums2[j];
                j++;
                k++;
            }

        }

        double mediue;

        if(length % 2 != 0){
            mediue = nums[length / 2];
        }else {
            int a1 = nums[(length - 1) / 2];
            int a2 = nums[(length - 1) / 2 + 1];
            mediue = (a1 + a2) / 2.0;
        }
        return mediue;
    }

    @Test
    void test(){
        int[] nums1 = {-1, 0};
        int[] nums2 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}