package com.dobeye;

public class EuclidsAlgorithm {
    static int finalA;
    static int finalB = 1;
    static int finalC;
    static int finalD;
    static int step = 0;

    public static void euclidsAlgorithm (int a, int b) {
        if (!checkCoPrime(a, b))
            System.out.println("those aren't coprime numbers");
        else {
            if (a % b == 1) {
                System.out.println(a + " - " + ((a - 1) / b) + " * " + b + " = 1");
            } else {
                int d = a % b;
                int c = (a - d) / b;
                int nextA = b;
                int nextB = a % b;
                int nextD = nextA % nextB;
                int nextC = (nextA - nextD) / nextB;

                if (nextD != 1)
                    euclidsAlgorithm(nextA, nextB);

                if (step == 0) {
                    finalA = b;
                    finalC = d;
                    finalD = nextC;
                }

                if (step % 2 == 0) {
                    finalB += finalD * c;
                    finalC = a;
                } else {
                    finalA = a;
                    finalD += finalB * c;
                }
                step++;
                System.out.println(finalA + " * " + finalB + " - " + finalC + " * " + finalD + " = 1");
            }
        }

    }

    public static boolean checkCoPrime (int a, int b) {
        if (a%b == 0)
            return false;
        if (a%b == 1)
            return true;
        return checkCoPrime(b, a%b);
    }
}
