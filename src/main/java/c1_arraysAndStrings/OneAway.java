package c1_arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class OneAway {

    public boolean isOneAway(String s1, String s2) {
        int p1 = 0;
        int p2 = 0;
        int diff = 0;

        while (p1 < s1.length() || p2 < s2.length()) {
            Character c1 = p1 >= s1.length() ? null : s1.charAt(p1);
            Character c2 = p2 >= s2.length() ? null : s2.charAt(p2);

            if (c1 != null && c2 != null && c1.equals(c2)) {
                p1++;
                p2++;
                continue;
            }

            diff++;
            if (s1.length() <= s2.length()) p2++;
            if (s2.length() <= s1.length()) p1++;
        }

        return diff <= 1;
    }

    @Test
    public void test() {
        Assert.assertTrue(isOneAway("", "a"));
        Assert.assertTrue(isOneAway("a", "a"));
        Assert.assertFalse(isOneAway("", "aa"));
        Assert.assertTrue(isOneAway("pale", "ple"));
        Assert.assertTrue(isOneAway("pales", "pale"));
        Assert.assertTrue(isOneAway("pale", "bale"));
        Assert.assertFalse(isOneAway("pale", "bake"));
    }
}