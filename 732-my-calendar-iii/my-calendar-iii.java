class MyCalendarThree {
    private TreeMap<Integer, Integer> bookings;
    private int maxOverlap;

    public MyCalendarThree() {
        bookings = new TreeMap<>();
        maxOverlap = 0;
    }

    public int book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int delta : bookings.values()) {
            active += delta;
            maxOverlap = Math.max(maxOverlap, active);
        }

        return maxOverlap;
    }
}
