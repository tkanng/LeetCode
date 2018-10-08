import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//Definition for an interval.
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals, List<Interval> res) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;// 按照start升序排列
            }
        });
        if (intervals.size() == 0)
            return res;
        Interval oneInterval = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i < intervals.size(); ++i) {
            Interval tmp = intervals.get(i);
            if (tmp.start > oneInterval.end) {
                res.add(oneInterval);
                oneInterval = new Interval(tmp.start, tmp.end);
            } else {
                if (tmp.end > oneInterval.end) {
                    oneInterval.end = tmp.end;
                }
            }
        }
        // 最后一个
        res.add(oneInterval);
        return res;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        intervals.add(newInterval);
        merge(intervals, res);
        return res;
    }
}
