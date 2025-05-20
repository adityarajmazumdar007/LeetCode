
public class StockPrice {
    private int latestTimestamp;
    private int latestPrice;
    private final Map<Integer, Integer> timestampToPrice;  
    private final TreeMap<Integer, Integer> priceFrequencies;

    public StockPrice() {
        this.latestTimestamp    = -1;
        this.latestPrice        = -1;
        this.timestampToPrice   = new HashMap<>();
        this.priceFrequencies   = new TreeMap<>();
    }

    /**
     * Record a price update at the given timestamp.  If the same timestamp
     * was updated before, adjust the old price’s frequency down.
     */
    public void update(int timestamp, int price) {
        // 1) Update “latest” if this is the newest timestamp so far
        if (timestamp >= latestTimestamp) {
            latestTimestamp = timestamp;
            latestPrice     = price;
        }

        // 2) If we had a previous price at this timestamp, decrement its count
        Integer previousPrice = timestampToPrice.get(timestamp);
        if (previousPrice != null) {
            int prevCount = priceFrequencies.get(previousPrice) - 1;
            if (prevCount == 0) {
                priceFrequencies.remove(previousPrice);
            } else {
                priceFrequencies.put(previousPrice, prevCount);
            }
        }

        // 3) Record the new price for this timestamp
        timestampToPrice.put(timestamp, price);

        // 4) Increment the frequency for the new price
        priceFrequencies.put(price, priceFrequencies.getOrDefault(price, 0) + 1);
    }

    /** @return the price at the most recent timestamp. */
    public int current() {
        return latestPrice;
    }

    /** @return the maximum price seen so far. */
    public int maximum() {
        return priceFrequencies.lastKey();
    }

    /** @return the minimum price seen so far. */
    public int minimum() {
        return priceFrequencies.firstKey();
    }
}
