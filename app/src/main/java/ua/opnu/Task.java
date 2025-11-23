package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Collections;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; ) {
            String str1 = list.get(i);
            String str2 = list.get(i + 1);

            if (str1.length() <= str2.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i++;
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i + 1 < list.size(); i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int n = queue.size();

        for (int i = 0; i < n; i++) {
            int v = queue.poll();
            st.push(v);
            queue.offer(v);
        }
        for (int i = 0; i < n; i++) {
            int v = queue.poll();
            if (v != st.pop()) return false;
            queue.offer(v);
        }
        return true;
    }

    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int value = queue.poll();
            stack.push(value);
        }
        List<Integer> tempList = new ArrayList(stack);
        tempList.sort(Integer::compareTo);
        for (Integer v : tempList) {
            queue.offer(v);
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            int v = queue.poll();
            if (v % 2 == 0) queue.offer(v);
            else stack.push(v);
        }
        while (!stack.isEmpty()) queue.offer(stack.removeLast());
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            max = Math.max(max, s.length());
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String value : map.values()) {
            if (!values.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> r = new HashMap<>();
        Map<String, Integer> small = (map1.size() < map2.size()) ? map1 : map2;
        Map<String, Integer> big = (small == map1) ? map2 : map1;

        for (Map.Entry<String, Integer> entry : small.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

             if (big.containsKey(key)) {
                 Integer otherValue = big.get(key);

                if (value.equals(otherValue)) {
                    r.put(key, value);
                }
            }
        }
        return r;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> f = new HashMap<>();
        for (Integer v : map.values()) {
            f.put(v, f.getOrDefault(v, 0) + 1);
        }
        int minCount = Integer.MAX_VALUE;
        int rareValue = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : f.entrySet()) {
            if (entry.getValue() < minCount || (entry.getValue() == minCount && entry.getKey() < rareValue)) {
                minCount = entry.getValue();
                rareValue = entry.getKey();
            }
        }
        return rareValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;
        Map<Integer, Integer> f = new HashMap<>();
        for (int v : list) f.put(v, f.getOrDefault(v, 0) + 1);
        return Collections.max(f.values());
    }

}
