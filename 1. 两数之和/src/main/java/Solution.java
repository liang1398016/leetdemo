import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0, len1 = nums.length; i <= len1 -1; i++){
            for(int j = i + 1, len2 = nums.length; j <= len2 -1; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for(int i = 0, len = nums.length; i <= len - 1; i ++){
            int buffer = target - nums[i];
            if(hashMap.containsKey(buffer)){
                return new int[]{i, hashMap.get(buffer)};
            }
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}