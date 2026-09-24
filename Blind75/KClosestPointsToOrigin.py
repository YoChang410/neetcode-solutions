import math
import heapq

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        dists = [(-math.sqrt(x[0]**2 + x[1]**2), x[0], x[1]) for x in points]
        heapq.heapify(dists)
        while len(dists) > k:
            heapq.heappop(dists)
        return [[x[1] ,x[2]] for x in dists]