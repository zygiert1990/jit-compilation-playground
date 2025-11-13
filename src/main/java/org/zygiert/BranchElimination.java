package org.zygiert;

public class BranchElimination {

    static void main() {
        IO.println("My fantastic result is: " + compute());
    }

    private static int compute() {
        var sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += resolveNumber(i);
        }
        return sum;
    }

    private static int resolveNumber(int i) {
        if (i < 1_000_001) return i;
        else return i * 2;
    }

}
