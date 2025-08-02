import java.util.*;

public class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : basket1) freq.put(x, freq.getOrDefault(x, 0) + 1);
        for (int x : basket2) freq.put(x, freq.getOrDefault(x, 0) + 1);

        // Step 1: Check if possible
        for (int count : freq.values()) {
            if (count % 2 != 0) return -1;
        }

        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();
        for (int x : basket1) freq1.put(x, freq1.getOrDefault(x, 0) + 1);
        for (int x : basket2) freq2.put(x, freq2.getOrDefault(x, 0) + 1);

        List<Integer> A = new ArrayList<>(); // Excess in basket1
        List<Integer> B = new ArrayList<>(); // Excess in basket2
        int minAll = Integer.MAX_VALUE;
        for (int x : freq.keySet()) {
            minAll = Math.min(minAll, x);
            int total = freq.get(x);
            int want = total / 2;
            int c1 = freq1.getOrDefault(x, 0);
            int c2 = freq2.getOrDefault(x, 0);

            if (c1 > want) {
                for (int i = 0; i < c1 - want; i++) A.add(x);
            } else if (c2 > want) {
                for (int i = 0; i < c2 - want; i++) B.add(x);
            }
        }

        // Step 2: Minimize cost using the smaller swap cost or double-minAll trick
        Collections.sort(A); // ascending
        Collections.sort(B, Collections.reverseOrder()); // descending for best min(A[i], B[i])
        long res = 0;
        for (int i = 0; i < A.size(); i++) {
            int a = A.get(i);
            int b = B.get(i);
            res += Math.min(Math.min(a, b), 2 * minAll);
        }
        return res;
    }
}
