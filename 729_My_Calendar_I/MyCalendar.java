class MyCalendar {
    
    TreeSet<int[]> events;
    
    public MyCalendar() {
        // sort pair based on first entry then second entry
        events = new TreeSet<int[]>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
    }
    
    public boolean book(int start, int end) {
        int[] newEvent = new int[] {start, end};
        int[] closestPrevEvent = events.floor(newEvent);
        int[] closestPostEvent = events.ceiling(newEvent);
        boolean prevCompat = true;
        boolean postCompat = true;
        if (closestPrevEvent != null && closestPrevEvent[1] > start) prevCompat = false;
        if (closestPostEvent != null && closestPostEvent[0] < end) postCompat = false;
        if (prevCompat && postCompat) {
            events.add(newEvent);
        }
        return prevCompat && postCompat;
    }
}
