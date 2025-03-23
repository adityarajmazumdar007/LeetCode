import java.util.*;

class Solution {
    public int maxLength(List<String> arr) {

        String[] arrArray = arr.toArray(new String[arr.size()]);
        
        
        return maxLength(arrArray);
    }

    private int maxLength(String[] arr) {
        // Call the solve method
        return solve(0, arr, "", new HashMap<>());
    }
    
    // Recursive method to find the maximum length of a concatenated string
    private int solve(int idx, String[] arr, String temp, Map<String, Integer> mp) {
        // Base case: If we have processed all strings in the array
        if (idx == arr.length) {
            return temp.length();
        }
        
        // If the current temporary string has already been encountered before
        if (mp.containsKey(temp)) {
            return mp.get(temp);
        }
        
        // Exclude the current string and move to the next one
        int exclude = solve(idx + 1, arr, temp, mp);
        
        // Include the current string if it has no common characters with the temporary string
        int include = 0;
        if (!hasCommon(arr[idx], temp)) {
            include = solve(idx + 1, arr, temp + arr[idx], mp);
        }
        
        // Maximum length considering both included and excluded cases
        int maxLength = Math.max(exclude, include);
        
        // Memoize the result
        mp.put(temp, maxLength);
        
        return maxLength;
    }
    
    // Helper method to check if two strings have common characters
    private boolean hasCommon(String s1, String s2) {
        int[] arr = new int[26];
        
        for (char ch : s1.toCharArray()) {
            if (arr[ch - 'a'] > 0) {
                return true;
            }
            arr[ch - 'a']++;
        }
        
        for (char ch : s2.toCharArray()) {
            if (arr[ch - 'a'] > 0) {
                return true;
            }
        }
        
        return false;
    }
}
