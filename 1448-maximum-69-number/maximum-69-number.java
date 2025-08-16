class Solution {
    public int maximum69Number (int num) {
         char[] digits = Integer.toString(num).toCharArray();

        // Scan from the most significant digit (left) to the least.
        for (int i = 0; i < digits.length; i++) {
            // First time we see a '6', flipping it to '9' yields the largest increase.
            if (digits[i] == '6') {
                digits[i] = '9'; // perform the single allowed change
                break;           // stop; further changes would reduce optimality or violate "at most one"
            }
        }

        // Build the new number and return it as int.
        return Integer.parseInt(new String(digits));
    }
}