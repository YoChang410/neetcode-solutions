'''
Solution for the problem: 
https://neetcode.io/problems/cheapest-flight-path/question?list=companyTagged&company=Stripe 
'''
class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        prices = [9999999] * n
        prices[src] = 0
        
        for a in range(k+1):
            tempPrices = prices.copy()
            for flight in flights:
                srcPort = flight[0]
                dstPort = flight[1]
                cost = flight[2]
                tempPrices[dstPort] = min(tempPrices[dstPort], prices[srcPort] + cost)
            for x in range(n):
                prices[x] = min(prices[x], tempPrices[x])

        if prices[dst] == 9999999:
            return -1
        else:
            return prices[dst]


