package c1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Urlify {

    public String urlify(String s, int len) {
        return s.trim().replaceAll(" ", "%20");
    }

    public String urlify_noLibraryFuncs(String s, int len) {
        char[] chars = s.toCharArray();
        int end = len - 1;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ' ') {
                // Shuffle everything up 2 spaces
                for (int j = end; j > i; j--) {
                    chars[j+2] = chars[j];
                }
                end += 2;
                chars[i] = '%';
                chars[i+1] = '2';
                chars[i+2] = '0';
                i += 2;
            }
        }

        return new String(chars);
    }

    @Test
    public void test() {
        Assert.assertEquals("Mr%20John%20Smith", urlify("Mr John Smith    ", 13));
        Assert.assertEquals("Mr%20John%20Smith", urlify_noLibraryFuncs("Mr John Smith    ", 13));
    }
}