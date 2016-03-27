package c1;

import org.junit.Assert;
import org.junit.Test;

public class StringCompression {

    public String compress(String s) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                compressed = compressed.append(s.charAt(i - 1) + Integer.toString(count));
                count = 1;
            }
        }

        return compressed.length() < s.length() ? compressed.toString() : s;
    }

    @Test
    public void test() {
        Assert.assertEquals("a2b1c5a3", compress("aabcccccaaa"));
        Assert.assertEquals("aBC", compress("aBC"));
        Assert.assertEquals("A1B1C5", compress("ABCCCCC"));
    }
}