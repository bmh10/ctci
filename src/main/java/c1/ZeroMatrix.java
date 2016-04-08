package c1;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ZeroMatrix {

    public void zeroify(int[][] A) {
        final int M = A.length;
        final int N = A[0].length;
        final Map<Integer, Integer> zeroIdxs = new HashMap<Integer, Integer>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 0) {
                    zeroIdxs.put(i, j);
                }
            }
        }

        for (Map.Entry<Integer, Integer> idx : zeroIdxs.entrySet()) {
            zeroify(A, idx.getKey(), idx.getValue());
        }
    }

    private void zeroify(int[][] A, int row, int col) {
        final int M = A.length;
        final int N = A[0].length;

        for (int m = 0; m < M; m++) {
            A[m][col] = 0;
        }

        for (int n = 0; n < N; n++) {
            A[row][n] = 0;
        }
    }

    @Test
    public void test() {
        final int[][] A =
                {{ 1,  2,  3,  4 },
                 { 5,  6,  0,  8 },
                 { 9,  10, 11, 12 }};

        final int[][] Aans =
                {{ 1,  2,  0,  4 },
                 { 0,  0,  0,  0 },
                 { 9,  10, 0, 12 }};

        zeroify(A);
        Assert.assertEquals(Arrays.deepToString(Aans), Arrays.deepToString(A));
    }
}