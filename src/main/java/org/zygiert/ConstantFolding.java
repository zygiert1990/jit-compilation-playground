package org.zygiert;

public class ConstantFolding {

    static void main() {
        IO.println("My fantastic result is: " + compute());
    }

    private static int compute() {
        var sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += resolveNumber(i, 101) + resolveNumber(i, 202);
        }
        return sum;
    }

    private static int resolveNumber(int i, int j) {
        return i * j;
    }

}
