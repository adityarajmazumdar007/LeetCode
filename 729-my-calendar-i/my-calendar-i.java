class MyCalendar {
    TreeMap<Integer,Integer> bookings;
    private int maxAllowed;
    public MyCalendar() {   
        bookings = new TreeMap<>();
        maxAllowed = 1;
    }
    
    public boolean book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);

        int overlapCount = 0;

        //prefix sum of bookings.
        for (Map.Entry<Integer, Integer> entry : bookings.entrySet()) {
            overlapCount += entry.getValue();
            if (overlapCount > maxAllowed) {
                bookings.put(start, bookings.get(start) - 1);
                bookings.put(end, bookings.get(end) + 1);
                if (bookings.get(start) == 0) {
                    bookings.remove(start);
                }
                if (bookings.get(end) == 0) {
                    bookings.remove(end);
                }
                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */