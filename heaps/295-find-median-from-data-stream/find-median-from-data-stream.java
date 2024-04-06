class MedianFinder {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) { 
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if ((minHeap.size() + maxHeap.size()) % 2 == 0) return (minHeap.peek() + maxHeap.peek()) / 2.0d;
        return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */