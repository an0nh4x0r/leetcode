/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) return true;

        // Write your code here
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval prevInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); ++i) {
            if (prevInterval.end > intervals.get(i).start) {
                return false;
            } else {
                prevInterval = intervals.get(i);
            }
        }

        return true;

    }
}