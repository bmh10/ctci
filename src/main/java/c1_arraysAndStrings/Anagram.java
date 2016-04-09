package c1_arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    // Time O(N) Space O(N)
    public boolean isAnagram(final String s1, final String s2) {
        final Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s1.toCharArray()) {
            int freq = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, freq + 1);
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            int count = map.get(c);
            count--;
            if (count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }

        return map.isEmpty();
    }

    @Test
    public void test() {
        Assert.assertTrue(isAnagram("", ""));
        Assert.assertTrue(isAnagram("abc", "cba"));
        Assert.assertTrue(isAnagram("abccc", "ccabc"));

        Assert.assertFalse(isAnagram("a", "b"));
        Assert.assertFalse(isAnagram("abc", "abcc"));
        Assert.assertFalse(isAnagram("abc", "cde"));
    }
}