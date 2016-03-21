package c1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    // Time O(N) Space O(N)
    public boolean allUnique(final String s) {
        final Set<Character> set = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        return set.size() == s.length();
    }

    // Time O(Nlog(N)) Space O(1)
    public boolean allUnique_noDataStructure(String s) {
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        Assert.assertTrue(allUnique("a"));
        Assert.assertTrue(allUnique("abcdefg"));
        Assert.assertFalse(allUnique("abcdeff"));

        Assert.assertTrue(allUnique_noDataStructure("a"));
        Assert.assertTrue(allUnique_noDataStructure("abcdefg"));
        Assert.assertFalse(allUnique_noDataStructure("abcdeff"));
    }
}