package dumaisoft.chapter03;

/**
 * Author:      wxb
 * Project:     Grokking_algorithms_in_java
 * Create Date: 2017/12/13
 * Create Time: 20:39
 * Description: simple example for recursion function
 */
public class CountDown {
    public static void main(String[] args) {
        countDown(5);
    }

    private static void countDown(int i) {
        System.out.println(i);
        if (i <= 0) {
            return;
        } else {
            countDown(i - 1);
        }
    }
}
