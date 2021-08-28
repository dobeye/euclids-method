package com.dobeye;

public class EuclidsAlgorithm {
    private static final int[] finalArr = {0, 1, 0, 0};
    private static int step = 0;

    public static int[] euclidsAlgorithm (int a, int b) {
        if (!checkCoPrime(a, b)) {
            System.out.println("those aren't co-prime numbers");
            return null;
        }

        if (a % b == 1)
            return new int[]{a, 1, ((a - 1) / b), b};

        internalFunction(a, b);
        return finalArr;
    }

    private static void internalFunction (int a, int b) {
        int d = a % b;
        int c = (a - d) / b;

        if (b % d != 1)
            internalFunction(b, d);

        if (step == 0) {
            finalArr[0] = b;
            finalArr[2] = d;
            finalArr[3] = (b - b % d) / d;
        }

        if (step % 2 == 0) {
            finalArr[1] += finalArr[3] * c;
            finalArr[2] = a;
        } else {
            finalArr[0] = a;
            finalArr[3] += finalArr[1] * c;
        }

        step++;
    }

    public static boolean checkCoPrime (int a, int b) {
        if (a % b == 0)
            return false;
        if (a % b == 1)
            return true;
        return checkCoPrime(b, a % b);
    }

    public static String toString (int[] intArr) {
        if (intArr == null)
            return "";

        return String.format("%d * %d - %d * %d = 1", intArr[0], intArr[1], intArr[2], intArr[3]);
    }

    public static void printEuclidsMethod (int a, int b) {
        System.out.println(toString(euclidsAlgorithm(a, b)));
    }

}
