package dumaisoft.chapter06;

import java.util.*;

/**
 * Author:      wxb
 * Project:     Grokking_algorithms_in_java
 * Create Date: 2017/12/14
 * Create Time: 20:40
 * Description: simple example for breadth-first search in a graph.
 */
public class BreadthFristSearch {
    public static void main(String[] args) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        graph.put("you", new LinkedList<String>(Arrays.asList("alice", "bob", "claire")));
        graph.put("bob", new LinkedList<String>(Arrays.asList("anuj", "peggy")));
        graph.put("alice", new LinkedList<String>(Arrays.asList("peggy")));
        graph.put("claire", new LinkedList<String>(Arrays.asList("thom", "jonny")));
        graph.put("anuj", new LinkedList<String>());
        graph.put("peggy", new LinkedList<String>());
        graph.put("thom", new LinkedList<String>());
        graph.put("jonny", new LinkedList<String>());

        LinkedList<String> search_queue = new LinkedList<String>();
        LinkedList<String> searched = new LinkedList<String>();

        search_queue.addAll(graph.get("you"));
        while (!search_queue.isEmpty()) {
            String person = search_queue.poll();
            if (!searched.contains(person)) {
                if (person_is_seller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return;
                } else {
                    search_queue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        System.out.println("there is no mango seller!");
    }

    private static boolean person_is_seller(String name) {
        return name.endsWith("m");
    }
}
