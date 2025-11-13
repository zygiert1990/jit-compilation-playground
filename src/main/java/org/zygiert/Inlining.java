package org.zygiert;

public class Inlining {

    static void main() {
        IO.println("My fantastic sum is: " + compute());
    }

    private static int compute() {
        var sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += resolveNumber(i);
        }
        return sum;
    }

    private static int resolveNumber(int i) {
        return i + i;
    }

}
