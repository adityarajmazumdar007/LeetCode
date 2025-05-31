class Solution {
    public int countTime(String time) {
       
        if (time.equals("??:??"))
            return 24 * 60;

        int res = 1;

        // if both hour hands are empty, 24 possibilities.
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            res = res * 24;
        } else if (time.charAt(0) == '?') {
            /**
             * if 2nd hand already at 4 or above, first hand can only have 2 possibilities -
             * 0 and 1
             * if 2nd hand = 5 => 05:00, 15:00, (25:00 is not possible.)
             * if 2nd hand less than 4, then 3 possibilities
             * if 2nd hand = 2 => 02:00, 12:00, 22:00 - all 3 possible
             */
            if (time.charAt(1) - '0' >= 4)
                res = res * 2;
            else
                res = res * 3;
        } else if (time.charAt(1) == '?') {
            // if hour hand is >= 2, only 4 possibilities for min hand {20, 21, 22, 23}
            if (time.charAt(0) - '0' >= 2)
                res = res * 4;
            /// or else 10 possibilities for hour 0X and hour 1X {00, 01, 02... 09} or {10,
            /// 11, 12... 19}
            else
                res = res * 10;
        }
        // if 2nd min hand is empty, 10 possibilities, XX:X0, XX:X1, XX:X2... XX:X9
        // after 19 min, it needs to go to 20 min, it can's be 1(10) min
        if (time.charAt(4) == '?')
            res = res * 10;
        // if 1st min hand is empty, 6 possibilities, XX:0X, XX:1X, XX:2X... XX:5X
        // after 59 min, it needs to go back to 00 min, it can't go to 63 min
        if (time.charAt(3) == '?')
            res = res * 6;
        return res;
    }
}