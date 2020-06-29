import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int length = 0;

        for(int i  = 0, j = 0, len = s.length(); i <= len -1; i ++ ){
            Character c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }else {
                int setSize = set.size();
                if(length < setSize)  length = setSize;
                set.clear();

                j ++;
                i = j - 1;
            }
        }
        if(length < set.size())  length = set.size();
        return length;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        ArrayList<Character> arr = new ArrayList<Character>();
        int length = 0;

        for(int i  = 0, j = 0, len = s.length(); i <= len -1; i ++){
            Character c = s.charAt(i);
            if(arr.contains(c)){
                while (arr.remove(0) != c);
                j++;
            }
            arr.add(c);
            if(length < arr.size())  length = arr.size();
            System.out.println(arr);
        }
        return length;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


    @Test
    public void test(){
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(str));
    }
}