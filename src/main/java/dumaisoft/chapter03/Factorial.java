package dumaisoft.chapter03;

/**
 * Author:      wxb
 * Project:     Grokking_algorithms_in_java
 * Create Date: 2017/12/13
 * Create Time: 20:36
 * Description: compute the factorial number
 */
public class Factorial {
    public static void main(String[] args) {
        int n = factorail(5);
        System.out.println(n);
    }

    private static int factorail(int x) {
        if (x == 0) {
            return 1;
        }
        return x*factorail(x-1);
    }
}
