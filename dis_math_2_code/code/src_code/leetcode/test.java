package src_code.leetcode;

import java.util.*;

public class test {
  public int maxOperations(int[] nums, int k) {
    int count = 0;

    Set<Integer> set = new HashSet<>();
    HashMap<Integer, Queue<Integer>> map = new HashMap<>();

    for (int num : nums) {

      if (!map.containsKey(num) && map.get(num).size() == 1) {
        map.put(num, new ArrayDeque<>());
        map.get(num).add(num);
      }

      if (map.containsKey(k - num)) {
        count++;

        map.get(k - num).poll();

        if (map.get(k - num).isEmpty()) {
          map.remove(k - num);
        }
      } else {
        map.get(num).add(num);
      }
    }
    return count;
  }
}
