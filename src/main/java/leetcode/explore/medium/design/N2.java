package leetcode.explore.medium.design;

import java.util.*;

public class N2 {

    private Map<Integer, Integer> map;
    private List<Integer> list;

    /** Initialize your data structure here. */
    public N2() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.remove(val);
        int last = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        if (last != val) {
            list.set(index, last);
            map.put(last, index);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (list.size() < 1) {
            return -1;
        }
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
