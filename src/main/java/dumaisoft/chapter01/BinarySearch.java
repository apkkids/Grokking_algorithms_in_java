package dumaisoft.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wxb on 2017/12/8 0008.
 */
public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9));
        int index = binary_search(list, 3);
        if (index > -1) {
            System.out.println("find item, index = " + index);
        }
    }

    private static int binary_search(List<Integer> list, int item) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list.get(mid);
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
