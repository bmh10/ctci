package c1_arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RotateMatrix {

    public int[][] rotateMatrix(int[][] A) {
        final int N = A.length;
        int[][] B = new int[N][N];

        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                B[row][col] = A[N - col - 1][row];
            }
        }

        return B;
    }

    public void rotateMatrixInPlace(int[][] A) {
        final int N = A.length;
        int pl = N; // phase length
        int p = 0; // phase start position / layer

        while (pl > 1) {
            for (int i = 0; i < pl - 1; i++) {
                int tmp = A[p][p+i];
                A[p][p+i] = A[p+pl-1-i][p];
                A[p+pl-1-i][p] = A[p+pl-1][p+pl-1-i];
                A[p+pl-1][p+pl-1-i] = A[p+i][p+pl-1];
                A[p+i][p+pl-1] = tmp;
            }

            pl -= 2;
            p++;
        }
    }

    @Test
    public void test() {
        final int[][] A =
                {{ 1,  2,  3,  4 },
                 { 5,  6,  7,  8 },
                 { 9,  10, 11, 12 },
                 { 13, 14, 15, 16 }};

        final int[][] Aans =
                {{ 13,  9, 5, 1 },
                {  14, 10, 6, 2 },
                {  15, 11, 7, 3 },
                {  16, 12, 8, 4 }};

        Assert.assertEquals(Arrays.deepToString(Aans), Arrays.deepToString(rotateMatrix(A)));

        rotateMatrixInPlace(A);
        Assert.assertEquals(Arrays.deepToString(Aans), Arrays.deepToString(A));
    }
}