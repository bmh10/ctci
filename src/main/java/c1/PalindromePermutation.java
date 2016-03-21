package c1;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PalindromePermutation {

    public boolean isPalindromePermutation(String s) {
        s = s.trim().toLowerCase().replaceAll(" ", "");
        final Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            int val = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, val + 1);
        }

        boolean oneSeen = false;

        for (int val : map.values()) {
            if (val == 2) {
                continue;
            }

            if (val == 1 && !oneSeen) {
                oneSeen = true;
                continue;
            }

            return false;
        }

        return true;
    }

    @Test
    public void test() {
        Assert.assertTrue(isPalindromePermutation("Tact Coa"));
        Assert.assertTrue(isPalindromePermutation("Aabbc"));
        Assert.assertFalse(isPalindromePermutation("Abc"));
    }
}