/*
这道题主要用到思路是：滑动窗口

什么是滑动窗口？

* 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！

如何移动？

* 我们只要把队列的左边的元素移出就行了，直到满足题目要求！

一直维持这样的队列，找出队列出现最长的长度时候，求出解！

时间复杂度：O(n)
*/

public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;      //默认最长子串长度
        char[] chars = s.toCharArray();     //转化成char的数组
        int leftIndex = 0;         //窗口左侧起点
        for (int j = 0; j < chars.length; j++) {    //j是右边窗口
            for (int innerIndex = leftIndex; innerIndex < j; innerIndex++) {    //innerIndex是用来找当前子串内部有没有重复字符的
                if (chars[innerIndex] == chars[j]) {        //右侧窗口出现重复字符
                    maxLength = Math.max(maxLength, j - leftIndex);     //更新最长长度
                    leftIndex = innerIndex + 1;             //左边窗口移动到重复字符的右边
                    break;
                }
            }
        }
        return Math.max(chars.length - leftIndex, maxLength);       //要注意的地方
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "aaaaa";

        System.out.println(lengthOfLongestSubstring(str1));
        System.out.println(lengthOfLongestSubstring(str2));

    }
}