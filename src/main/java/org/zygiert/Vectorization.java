package org.zygiert;

import java.util.Arrays;

public class Vectorization {

    static void main() {
        var array = new int[1000000];
        Arrays.fill(array, 1);
        IO.println("Array length is: " + compute(array, array).length);
    }

    private static int[] compute(int[] a, int[] b) {
        var res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[i] + b[i];
        }
        return res;
    }

}
