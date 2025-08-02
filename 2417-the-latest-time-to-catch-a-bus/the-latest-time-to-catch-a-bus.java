class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
      Arrays.sort(buses);
        Arrays.sort(passengers);
        Set<Integer> passengerSet = new HashSet<>();
        for (int p : passengers) passengerSet.add(p);

        int m = passengers.length;
        int n = buses.length;
        int passengerIdx = 0;
        int lastBus = buses[n-1];

        List<Integer> boardedOnLastBus = new ArrayList<>();
        // Board all buses, collect passengers on last bus
        for (int i = 0; i < n; i++) {
            int curCapacity = 0;
            while (passengerIdx < m && passengers[passengerIdx] <= buses[i] && curCapacity < capacity) {
                if (i == n-1) { // Last bus
                    boardedOnLastBus.add(passengers[passengerIdx]);
                }
                passengerIdx++;
                curCapacity++;
            }
        }

        int latestTime;
        if (boardedOnLastBus.size() < capacity) {
            // Not full, can arrive at bus departure time
            latestTime = lastBus;
        } else {
            // Full, arrive before the latest passenger who boarded
            latestTime = boardedOnLastBus.get(boardedOnLastBus.size() - 1) - 1;
        }
        // Avoid passenger times
        while (passengerSet.contains(latestTime)) {
            latestTime--;
        }
        return latestTime;
    }
}