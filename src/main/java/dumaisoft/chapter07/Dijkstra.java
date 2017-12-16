package dumaisoft.chapter07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by wxb on 2017/12/16 0016.
 */
public class Dijkstra {
    public static void main(String[] args) {
        //create and initialize graph
        HashMap<String, HashMap<String, Float>> graph = new HashMap<String, HashMap<String, Float>>();
        graph.put("start", new HashMap<String, Float>() {
            {
                put("a", 6f);
                put("b", 2f);
            }
        });
        graph.put("a", new HashMap<String, Float>() {
            {
                put("fin", 1f);
            }
        });
        graph.put("b", new HashMap<String, Float>() {
            {
                put("a", 3f);
                put("fin", 5f);
            }
        });
        graph.put("fin", new HashMap<String, Float>());

        HashMap<String, Float> costs = new HashMap<String, Float>() {
            {
                put("a", 6f);
                put("b", 2f);
                put("fin", Float.POSITIVE_INFINITY);
            }
        };

        HashMap<String, String> parents = new HashMap<String, String>() {
            {
                put("a", "start");
                put("b", "start");
                put("fin", null);
            }
        };
        List<String> processed = new LinkedList<String>();
        //dijkstra's algorithm
        String node = find_lowest_cost_node(costs, processed);
        while (node != null) {
            float cost = costs.get(node);
            HashMap<String, Float> neighbors = graph.get(node);
            //遍历当前节点的所有邻居
            for (Map.Entry<String,Float> entry : neighbors.entrySet()) {
                String n = entry.getKey();
                float new_cost = entry.getValue() +cost;
                if (costs.get(n) > new_cost) {
                    costs.remove(n);
                    costs.put(n, new_cost);
                    parents.remove(n);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = find_lowest_cost_node(costs, processed);
        }
        System.out.println(costs);
        System.out.println(parents);
        printResult(costs, parents);
    }

    /**
     * 打印Dijkstra算法的结果
     * @param costs
     * @param parents
     */
    private static void printResult(HashMap<String, Float> costs, HashMap<String, String> parents) {
        System.out.print("The path is : start-->");
        String node = findParent(parents, "start");
        while (node != null && !node.equals("fin")) {
            String parent = findParent(parents, node);
            System.out.print(node + "-->");
            node = parent;
        }
        System.out.println("fin");
        System.out.println("The total cost is : "+costs.get("fin"));
    }

    private static String findParent(HashMap<String, String> parents, String node) {
        for (Map.Entry<String, String> entry : parents.entrySet()) {
            if (entry.getValue().equals(node)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static String find_lowest_cost_node(HashMap<String, Float> costs, List<String> processed) {
        float lowest_cost = Float.POSITIVE_INFINITY;
        String lowest_cost_node = null;
        for (Map.Entry<String, Float> entry : costs.entrySet()) {
            float cost = entry.getValue();
            if (cost < lowest_cost && !processed.contains(entry.getKey())) {
                lowest_cost = cost;
                lowest_cost_node = entry.getKey();
            }
        }
        return lowest_cost_node;
    }
}
