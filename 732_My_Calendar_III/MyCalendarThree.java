class MyCalendarThree {

    private TreeMap<Integer, Integer> timeline = new TreeMap<>();
    public int book(int s, int e) {
        timeline.put(s, timeline.getOrDefault(s, 0) + 1); // 1 new event will be starting at [s]
        timeline.put(e, timeline.getOrDefault(e, 0) - 1); // 1 new event will be ending at [e];
        int ongoing = 0, k = 0;
        for (int v : timeline.values())
            k = Math.max(k, ongoing += v);
        return k;
    }

    /********* My memory-exceeded solution using BIT ********************\
    private int[] BIT;
    private int maxK;
    private int maxIdx = 1000000000;

    public MyCalendarThree() {
        BIT = new int[maxIdx + 1]; // start and end are in the range of [0, 10^9]
    }

    public int book(int start, int end) {
        update(start, 1);
        update(end, -1);
        for (int i = start; i < end; ++i) {
            maxK = Math.max(maxK, readSingle(i));
        }
        return maxK;
    }

    private void update(int idx, int increment) {
        while (idx <= maxIdx) {
            BIT[idx] += increment;
            idx += (idx & -idx);
        }
    }

    private int readSingle(int idx) {
        int val = BIT[idx];
        if (idx > 0) {
            int prevIdx = idx - (idx & -idx);
            --idx;
            while (idx != prevIdx) {
                val -= BIT[idx];
                idx -= (idx & -idx);
            }
        }
        return val;
    }
    \********* My memory-exceeded solution using BIT ********************/
}
