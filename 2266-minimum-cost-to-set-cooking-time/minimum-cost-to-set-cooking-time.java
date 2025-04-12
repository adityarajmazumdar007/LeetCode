class Solution {

    /** Calculates the minimum cost to set the microwave timer to targetSeconds. */
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minOverallCost = Integer.MAX_VALUE;

        // Iterate through all possible MM:SS combinations
        // Max MM is targetSeconds / 60. Max SS is 99.
        int maxMM = targetSeconds / 60;
        // Optimization: No need to check minutes beyond what's possible
        for (int mm = 0; mm <= Math.min(99, maxMM + 1) ; mm++) {
            int remainingSeconds = targetSeconds - (mm * 60);
            // Check if remaining seconds are valid (0-99)
            if (remainingSeconds >= 0 && remainingSeconds <= 99) {
                int ss = remainingSeconds;
                // Calculate the cost for this valid mm:ss combination
                minOverallCost = Math.min(minOverallCost, calculateTypingCost(mm, ss, startAt, moveCost, pushCost));
            }
        }
        return minOverallCost;
    }

    /** Helper function to calculate the cost of typing a specific MM:SS time. */
    private int calculateTypingCost(int mm, int ss, int startAt, int moveCost, int pushCost) {
        String normalized = String.format("%02d%02d", mm, ss);

        // Find the actual sequence typed (remove leading zeros)
        String inputSequence = normalized;
        int firstDigitIndex = 0;
        while (firstDigitIndex < inputSequence.length() - 1 && inputSequence.charAt(firstDigitIndex) == '0') {
            firstDigitIndex++;
        }
        inputSequence = inputSequence.substring(firstDigitIndex);

        // Calculate the cost for typing this sequence
        int currentCost = 0;
        int currentFingerPos = startAt;

        for (char digitChar : inputSequence.toCharArray()) {
            int digit = digitChar - '0';
            // Add move cost if finger position changes
            if (digit != currentFingerPos) {
                currentCost += moveCost;
            }
            // Add push cost
            currentCost += pushCost;
            // Update finger position
            currentFingerPos = digit;
        }
        return currentCost;
    }
}