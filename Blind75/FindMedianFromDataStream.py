import heapq

class MedianFinder:

    def __init__(self):
        self.leftHeap = []
        self.rightHeap = []
        #left heap is a max-heap containing the lower half of hte numbers. the maximum value is the median or a contributor to the median
        #right heap is a min-heap. Follow logic above

    def addNum(self, num: int) -> None:
        if len(self.leftHeap) == 0:
            heapq.heappush(self.leftHeap, -num)
            #print("Added to leftHeap: ", self.leftHeap)
        elif num < -self.leftHeap[0]:
            heapq.heappush(self.leftHeap, -num)
            #print("Added to leftHeap: ", self.leftHeap)
        else:
            heapq.heappush(self.rightHeap, num)
            #print("Added to rightHeap: ", self.rightHeap)
        while len(self.leftHeap) - len(self.rightHeap) > 1:
            heapq.heappush(self.rightHeap, -heapq.heappop(self.leftHeap))
        while len(self.rightHeap) - len(self.leftHeap) > 1:
            heapq.heappush(self.leftHeap, -heapq.heappop(self.rightHeap))

        #print("added ", num, ": Heaps are now: ", self.leftHeap, self.rightHeap)

    def findMedian(self) -> float:
        if len(self.leftHeap) > len(self.rightHeap):
            return -self.leftHeap[0]
        elif len(self.leftHeap) < len(self.rightHeap):
            return self.rightHeap[0]
        else:
            return float(-self.leftHeap[0] + self.rightHeap[0])/2