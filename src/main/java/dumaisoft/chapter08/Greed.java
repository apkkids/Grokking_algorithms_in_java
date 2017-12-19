package dumaisoft.chapter08;

import java.util.*;

/**
 * Created by wxb on 2017/12/19 0019.
 */
public class Greed {
    public static void main(String[] args) {
        Set<String> states_needed = new HashSet<String>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, HashSet<String>> stations = new HashMap<String, HashSet<String>>() {
            {
                put("kone", new HashSet<String>(Arrays.asList("id", "nv", "ut")));
                put("ktwo", new HashSet<String>(Arrays.asList("wa", "id", "mt")));
                put("kthree", new HashSet<String>(Arrays.asList("or", "nv", "ca")));
                put("kfour", new HashSet<String>(Arrays.asList("nv", "ut")));
                put("kfive", new HashSet<String>(Arrays.asList("ca", "az")));
            }
        };
        Set<String> final_stations = new HashSet<String>();
        String best_station = null;
        Set<String> states_covered = null;
        while (!states_needed.isEmpty()) {
            best_station = null;
            states_covered = new HashSet<String>();
            for (Map.Entry<String, HashSet<String>> entry : stations.entrySet()) {
                Set<String> covered = entry.getValue();
                covered.retainAll(states_needed);
                if (covered.size() > states_covered.size()) {
                    best_station = entry.getKey();
                    states_covered = covered;
                }
            }
            final_stations.add(best_station);
            states_needed.removeAll(states_covered);
        }
        System.out.println("the result is : " + final_stations);
    }
}
