package dumaisoft.chapter02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wxb on 2017/12/10 0010.
 */
public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(5, 3, 6, 2, 10));
        List<Integer> sortedList = selectionSort(list);
        System.out.println(sortedList);
    }

    private static List<Integer> selectionSort(List<Integer> list) {
        List<Integer> newArr = new LinkedList<Integer>();
        while (!list.isEmpty()) {
            int smallest_index = findSmallest(list);
            newArr.add(list.remove(smallest_index));
        }
        return newArr;
    }

    private static int findSmallest(List<Integer> list) {
        int smallest = list.get(0);
        int smallest_index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallest = list.get(i);
                smallest_index = i;
            }
        }
        return smallest_index;
    }
}
