import org.junit.jupiter.api.Test;

/**
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public int[] runningSum(int[] nums) {
        int tmp = 0 ;
        for(int i = 0, len = nums.length; i <= len - 1; i ++){
            tmp += nums[i];
            nums[i] = tmp;
        }
        return nums;
    }

    @Test
    public void test1(){
        int[] args = runningSum(new int[]{1,2,3,4});

        for (int i : args)
            System.out.print(i + ",");
    }

    @Test
    public void test2(){
        int[] args = runningSum(new int[]{1,1,1,1,1});

        for (int i : args)
            System.out.print(i + ",");
    }

    @Test
    public void test3(){
        int[] args = runningSum(new int[]{3,1,2,10,1});

        for (int i : args)
            System.out.print(i + ",");
    }
}