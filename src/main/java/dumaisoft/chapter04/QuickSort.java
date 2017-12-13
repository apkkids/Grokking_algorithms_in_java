package dumaisoft.chapter04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:      wxb
 * Project:     Grokking_algorithms_in_java
 * Create Date: 2017/12/13
 * Create Time: 20:42
 * Description: quick sort algorithm , for List
 */
public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(10, 5, 2, 3));
        System.out.println(quicksort(list));
    }

    private static List<Integer> quicksort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        int pivot = list.get(0);
        List<Integer> less = new LinkedList<Integer>();
        List<Integer> greater = new LinkedList<Integer>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= pivot) {
                less.add(list.get(i));
            } else  {
                greater.add(list.get(i));
            }
        }

        List<Integer> lessSorted = quicksort(less);
        List<Integer> greaterSorted = quicksort(greater);
        List<Integer> result = new LinkedList<Integer>(lessSorted);
        result.add(pivot);
        result.addAll(greaterSorted);
        return result;
    }
}
