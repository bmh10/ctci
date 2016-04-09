package c1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StringRotation {

    // TODO: not complete - fails when repeated sequences
    public boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int p1 = 0;
        int p2 = 0;
        int matchStart = -1;
        StringBuilder sb = new StringBuilder();
        StringBuilder possMatch = new StringBuilder();

        while (p1 < s1.length() && p2 < s2.length()) {
            char c1 = s1.charAt(p1);
            char c2 = s2.charAt(p2);
            if (c1 == c2) {
                if (possMatch.length() == 0) {
                    matchStart = p2;
                }
                possMatch = possMatch.append(c1);
                p1++;
                p2++;
                continue;
            }

            sb = sb.append(possMatch);
            possMatch = new StringBuilder();
            p2 = matchStart + 1;
            sb = sb.append(c1);
            p1++;
        }

        // isSubstring() call
        return s2.contains(sb.toString());
    }

    @Test
    public void test() {
        Assert.assertTrue(isRotation("banana", "anaban"));
        Assert.assertTrue(isRotation("waterbottle", "erbottlewat"));
        Assert.assertTrue(isRotation("cat", "tca"));
        Assert.assertFalse(isRotation("cat", "tac"));
        Assert.assertFalse(isRotation("waterbottle", "erbottlewatz"));
    }
}