class MyCalendarTwo {
    
    private TreeMap<Integer, Integer> map;    
    
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > 2) {
                map.put(start, map.get(start) - 1);
                if(map.get(start) == 0) {
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if(map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }

    /******************** Incorrect answer for the following case *******************/
    // ["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book","book","book","book",
    // "book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book",
    // "book"]
    // [[],[47,50],[1,10],[27,36],[40,47],[20,27],[15,23],[10,18],[27,36],[17,25],[8,17],[24,33],[23,28],[21,27],
    // [47,50],[14,21],[26,32],[16,21],[2,7],[24,33],[6,13],[44,50],[33,39],[30,36],[6,15],[21,27],[49,50],[38,45],
    // [4,12],[46,50],[13,21]]

    // TreeSet<int[]> events;
    
    // public MyCalendarTwo() {
    //     events = new TreeSet<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
    // }
    
    // public boolean book(int start, int end) {
    //     int[] newEvent = new int[] {start, end};
    //     int[] prevEvent = events.floor(newEvent);
    //     if (prevEvent != null) {
    //         int[] secPrevEvent = events.lower(prevEvent);
    //         if (secPrevEvent != null && secPrevEvent[1] > start) return false;
    //     }
    //     int[] postEvent = events.ceiling(newEvent);
    //     if (postEvent != null) {
    //         int[] secPostEvent = events.higher(postEvent);
    //         if (secPostEvent != null && secPostEvent[0] < end) return false;
    //     }
    //     if (prevEvent != null && postEvent != null && prevEvent[1] > postEvent[0]) return false;
    //     events.add(newEvent);
    //     return true;
    // }
}
