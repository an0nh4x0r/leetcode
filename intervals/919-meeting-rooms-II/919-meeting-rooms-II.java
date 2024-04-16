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
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for (Interval interval: intervals) {
            start.add(interval.start);
            end.add(interval.end);
        }

        Collections.sort(start);
        Collections.sort(end);

        int s = 0;
        int e = 0;

        int result = 0;
        int count = 0;

        while (s < intervals.size()) {
            if (start.get(s) < end.get(e)) {
                s += 1;
                count += 1;
            } else {
                e += 1;
                count -= 1;
            }
            result = Math.max(result, count);
        }

        return result;
    }
}