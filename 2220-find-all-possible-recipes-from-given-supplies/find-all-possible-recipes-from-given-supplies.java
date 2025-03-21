import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        // Step 1: Build the graph and calculate in-degrees
        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                adj.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
            }
            inDegree.put(recipes[i], ingredients.get(i).size());
        }

        // Step 2: Initialize the queue with initial supplies
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for (String supply : supplies) {
            queue.offer(supply);
        }

        // Step 3: BFS to find all possible recipes
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (!adj.containsKey(curr)) continue;
            for (String recipe : adj.get(curr)) {
                inDegree.put(recipe, inDegree.get(recipe) - 1);
                if (inDegree.get(recipe) == 0) {
                    result.add(recipe);
                    queue.offer(recipe);
                }
            }
        }
        return result;
    }
}
